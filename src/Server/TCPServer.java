package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TCPServer implements Runnable {
	private String Saddr;
	private int port;
	public ServerSocket server;
	public Socket socketObject;
	public PrintWriter pw;
	public BufferedReader bf;
	private InetAddress addr;
	private String mode = "";
	private int sineFreq;
	private int sineAmp;
	private int squarePWM;
	private int sawtoothFreq;
	private SineGen sine;
	private SquareGen square;
	private SawtoothGen sawtooth;
	private int estimateInfinity = 700;
	private int normalAmplitude = 100;
	
	private int[] signal;
	private String signalName;
	private boolean finished = false;
	private boolean Connected = false;
	
//	private int w, h, border;
	private int numberOfSample = 800;


	public TCPServer(String Saddr, int port) {
		this.Saddr = Saddr;
		this.port = port;
	}

	public void run() {
		try {
			addr = InetAddress.getByName(Saddr);
			server = new ServerSocket(port, 1, addr);
			System.out.println("TCPServer start at " + Saddr + " port " + port);
			while (true) {
				socketObject = server.accept();
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				pw = new PrintWriter(new OutputStreamWriter(socketObject.getOutputStream(), StandardCharsets.UTF_8),
						true);
				bf = new BufferedReader(new InputStreamReader(socketObject.getInputStream(), StandardCharsets.UTF_8));
				pw.println("Hello World");
				while (!bf.readLine().equals("1"));
				System.out.println("Client is connected");
//				w = Integer.parseInt(bf.readLine());
//				h = Integer.parseInt(bf.readLine());
//				border = Integer.parseInt(bf.readLine());
				Connected = true;
				while ((mode = bf.readLine()) != null) {
					switch (mode) {
					case "sine":
						sineFreq = Integer.parseInt(bf.readLine());
						sineAmp = Integer.parseInt(bf.readLine());
						System.out.println("sine: " + sineFreq + " " + sineAmp);
						
						// calculate the array signal
						sine = new SineGen(numberOfSample, sineFreq, sineAmp);
						sine.generate();
						signal = sine.getSignal();
						signalName = sine.getName();
						//set flag for UDP to send the signal
						finished = true;
						break;
					case "square":
						squarePWM = Integer.parseInt(bf.readLine());
						System.out.println("Square: " + squarePWM);
						
						// calculate the array signal
						square = new SquareGen(numberOfSample, squarePWM);
						square.generate(estimateInfinity, 100, normalAmplitude);
						signal = square.getSignal();
						signalName = square.getName();
						
						// set flag for UDP to send the signal
						finished = true;
						break;
					case "sawtooth":
						sawtoothFreq = Integer.parseInt(bf.readLine());
						System.out.println("Sawtooth: " + sawtoothFreq);
						
						// calculate the array signal
						sawtooth = new SawtoothGen(numberOfSample, sawtoothFreq);
						sawtooth.generate(normalAmplitude);
						signal = sawtooth.getSignal();
						signalName = sawtooth.getName();
						
						// set flag for UDP to send the signal
						finished = true;
						break;
					case "bye":
						Connected = false;
						break;
					default:
						break;
					}					
				}
			}
		} catch (SocketException se) {
			System.out.println("Server on port " + port + " is down!!!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("unknownHost");
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO");
			;
		}
	}

	public String getSignalName() {
		return signalName;
	}

	public void stopServer() {
		if (server != null) {
			shutdownServer(server);
		}
	}

	private void shutdownServer(ServerSocket server) {
		try {
			if (socketObject != null) {
				pw.close();
				bf.close();
			}
			server.close();
			System.out.println("Server on port " + port + " is downxyz!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getSignal() {
		return signal;
	}

	public void setSignal(int[] signal) {
		this.signal = signal;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isConnected() {
		return Connected;
	}

	public void setConnected(boolean connected) {
		Connected = connected;
	}
}
