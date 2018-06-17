package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;

public class TCPClient implements Runnable {
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader bf;
	private String IPaddr;
	private int port;
	private boolean sendSine = false;
	private boolean sendSquare = false;
	private boolean sendSawtooth = false;
	private boolean TCPsent = false;
	private int SineFreq;
	private int SineAmp;
	private int SquarePWM;
	private int SawtoothFreq;
	private JFrame frame;

	public TCPClient(String IPaddr, int port, JFrame frame) {
		this.IPaddr = IPaddr;
		this.port = port;
		this.frame = frame;
	}

	@Override
	public void run() {
		try {
			socket = new Socket(IPaddr, port);
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			bf = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			System.out.println(bf.readLine());
			pw.println("1");
			while (true) {
				if (sendSine || sendSquare || sendSawtooth) {
					TCPsent = true;
				}
				if (sendSine) {
					pw.println("sine");
					pw.println(SineFreq);
					pw.println(SineAmp);
					sendSine = false;
				} else if (sendSquare) {
					pw.println("square");
					pw.println(SquarePWM);
					sendSquare = false;
				} else if (sendSawtooth) {
					pw.println("sawtooth");
					pw.println(SawtoothFreq);
					sendSawtooth = false;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			Warning warn = new Warning(frame, "Server is not detected. Please turn on server and reopen the program!");
		}
	}

	public void closeConnection() {
		try {
			pw.println("bye");
			pw.close();
			bf.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSendSine(boolean sendSine) {
		this.sendSine = sendSine;
	}

	public void setSendSquare(boolean sendSquare) {
		this.sendSquare = sendSquare;
	}

	public void setSendSawtooth(boolean sendSawtooth) {
		this.sendSawtooth = sendSawtooth;
	}

	public void setSineFreq(int sineFreq) {
		SineFreq = sineFreq;
	}

	public void setSineAmp(int sineAmp) {
		SineAmp = sineAmp;
	}

	public void setSquarePWM(int squarePWM) {
		SquarePWM = squarePWM;
	}

	public void setSawtoothFreq(int sawtoothFreq) {
		SawtoothFreq = sawtoothFreq;
	}

	public boolean isTCPsent() {
		return TCPsent;
	}

	public void setTCPsent(boolean TCPsent) {
		this.TCPsent = TCPsent;
	}
}
