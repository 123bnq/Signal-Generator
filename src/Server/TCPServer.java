package Server;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
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
	private ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private DataOutputStream dos = new DataOutputStream(bos);

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
				while (!bf.readLine().equals("1"))
					;
				System.out.println("Client is connected");

				while ((mode = bf.readLine()) != null) {
					switch (mode) {
					case "sine":
						sineFreq = Integer.parseInt(bf.readLine());
						sineAmp = Integer.parseInt(bf.readLine());
						System.out.println("sine: " + sineFreq + " " + sineAmp);
						// calculate the array signal
						break;
					case "rectangle":
						squarePWM = Integer.parseInt(bf.readLine());
						System.out.println("Square: " + squarePWM);
						// calculate the array signal
						break;
					case "sawtooth":
						sawtoothFreq = Integer.parseInt(bf.readLine());
						System.out.println("Sawtooth: " + sawtoothFreq);
						// calculate the array signal
						break;
					default:
						break;
					}

					// set the flag for UDP to transfer the array
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
}
