package Client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient implements Runnable {
	private DatagramSocket socket;
	private String IPaddr;
	private int port;
	private byte[] receiveData = new byte[1024];
	private byte[] sendData = new byte[1024];
	private boolean received = false;
	private String receivedString;

	private int[] signal;

	private ByteArrayInputStream bis;
	private DataInputStream dis;

	public UDPClient(String IPaddr, int port) {
		this.IPaddr = IPaddr;
		this.port = port;
	}

	@Override
	public void run() {

		try {
			InetAddress addr = InetAddress.getByName(IPaddr);
			socket = new DatagramSocket();
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length, addr, port);
			String s = "Hello World";
			sendData = s.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, addr, port);
			socket.send(sendPacket);
			socket.receive(receivePacket);
			String sr;
			sr = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
			System.out.println(sr);
			System.out.println("Client is connected");
			while (true) {
				socket.receive(receivePacket);
				received = true;
				byte[] receiveBytes = receivePacket.getData();
				System.out.println(receivePacket.getLength());
				int signalLength = receivePacket.getLength() >> 2;
				signal = new int[signalLength];
				for (int i = 0; i < signalLength; i++) {
					int j = i << 2;
					int x = 0;
					x += (receiveBytes[j++] & 0xff) << 0;
					x += (receiveBytes[j++] & 0xff) << 8;
					x += (receiveBytes[j++] & 0xff) << 16;
					x += (receiveBytes[j++] & 0xff) << 24;
					signal[i] = x;
				}
				System.out.println(signal.length);
				// bis = new ByteArrayInputStream(receivePacket.getData());
				// dis = new DataInputStream(bis);
				// for (int i = 0; i < receiveData.length; i++) {
				// dis.readInt();
				// }
				// dis.close();

				// receivedString = new String(receivePacket.getData(),
				// receivePacket.getOffset(), receivePacket.getLength());
				// switch (receivedString) {
				// case "sine":
				// break;
				// case "rectangle":
				// break;
				// case "sawtooth":
				// break;
				// default:
				// break;
				// }
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
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		socket.close();
	}

	public byte[] getReceiveData() {
		return receiveData;
	}

	public void setSendData(byte[] sendData) {
		this.sendData = sendData;
	}

	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

}
