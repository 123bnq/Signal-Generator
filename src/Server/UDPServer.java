package Server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer implements Runnable{
	private static DatagramSocket socket;
	private static byte[] buffer = new byte[250];
	private int port;
	
	public UDPServer(int port) {
		this.port = port;
	}
	

	@Override
	public void run() {
		try {
			if (socket == null) {
				socket = new DatagramSocket(port);
			}
			System.out.println("DATAGRAM SOCKET at " + port);
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			String st = new String(packet.getData(), packet.getOffset(), packet.getLength());
			System.out.println(st);
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			buffer = "Twitch Prime".getBytes();
			packet = new DatagramPacket(buffer, buffer.length, address, port);
			socket.send(packet);
//			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
