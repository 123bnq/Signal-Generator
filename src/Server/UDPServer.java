package Server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;


public class UDPServer implements Runnable {
	private DatagramSocket socket;
	private byte[] buffer = new byte[2000];
	private int port;
	private SocketAddress sokeaddr;

	private int[] signal;
	private String signalName;
	DatagramPacket signalPacket;
	private boolean finished;

	private ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private DataOutputStream dos = new DataOutputStream(bos);
	private boolean Connected;

	public UDPServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			socket = new DatagramSocket(8888);
			socket.setReuseAddress(true);
			System.out.println("DATAGRAM SOCKET at " + port);
			while (true) {
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				try {
					Thread.sleep(50);
				} catch (Exception e) {
				}
				String st = new String(packet.getData(), packet.getOffset(), packet.getLength());
				System.out.println(st);
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				buffer = "Twitch Prime".getBytes();
				packet = new DatagramPacket(buffer, buffer.length, address, port);
				socket.send(packet);
				Connected = true;
				while (Connected) {
					try {
						Thread.sleep(50);
					} catch (Exception e) {
					}
					if (finished) {
						System.out.println("udpserver receives signal");
						finished = false;
//						for (int i = 0; i < signal.length; i++) {
//							dos.writeInt(signal[i]);
//						}
//						dos.close();
//						buffer = bos.toByteArray();
						buffer = Converter.convert(signal);
						signalPacket = new DatagramPacket(buffer, buffer.length, address, port);
						socket.send(signalPacket);
					}

				}
			}
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			System.out.println("UDP Server is down!!!");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void shutdownServer() {
		socket.close();
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

	public void setSignalName(String signalName) {
		this.signalName = signalName;
	}

	public void setConnected(boolean connected) {
		Connected = connected;
	}
}
