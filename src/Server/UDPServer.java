package Server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	private static DatagramSocket socket;
	private static byte[] buffer = new byte[250];
	
	public static void main(String[] args) {
		try {
			socket = new DatagramSocket(5555);
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			String st = new String(packet.getData(), packet.getOffset(), packet.getLength());
			System.out.println(st);
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			buffer = "HelloWorld".getBytes();
			packet = new DatagramPacket(buffer, buffer.length, address, port);
			socket.send(packet);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
