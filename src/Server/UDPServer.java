package Server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class UDPServer implements Runnable{
	private static DatagramSocket socket;
	private static byte[] buffer = new byte[250];
	private int port;
	private boolean condition;
	private SocketAddress sokeaddr;
	
	public UDPServer(int port, boolean condition) {
		this.port = port;
		this.condition = condition;
	}
	

	@Override
	public void run() {
		try {
			socket = new DatagramSocket(8888);
			socket.setReuseAddress(true);
			System.out.println("DATAGRAM SOCKET at " + port);
			while (true){
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				try {
					Thread.sleep(50);
				} catch (Exception e) {}
				String st = new String(packet.getData(), packet.getOffset(), packet.getLength());
				System.out.println(st);
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				buffer = "Twitch Prime".getBytes();
				packet = new DatagramPacket(buffer, buffer.length, address, port);
				socket.send(packet);
			}
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void shutdownServer(){
		socket.close();
	}


	public void setCondition(boolean condition) {
		this.condition = condition;
	}
}
