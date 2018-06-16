package Client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import Server.Converter;

public class UDPClient implements Runnable {
	private DatagramSocket socket;
	private String IPaddr;
	private int port;
	private byte[] receiveData = new byte[2000];
	private byte[] sendData = new byte[2000];
	private boolean received = false;
	
	public static int counter = 0;
	
	private int[] signal;

	public int[] getSignal() {
		return signal;
	}

	private ByteArrayInputStream bis;
	private DataInputStream dis;

	public UDPClient(String IPaddr, int port) {
		this.IPaddr = IPaddr;
		this.port = port;
		counter++;
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
				System.out.println(received == true);
				signal = Converter.convert(receivePacket);
				System.out.print("UDP client: ");
				for (int i = 0; i < signal.length; i++) {
					System.out.print(signal[i] + " ");
				}
				System.out.println();
				System.out.println(receivePacket.getLength());
				System.out.println(signal.length);
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
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			System.out.println("Close UDP connection");
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
