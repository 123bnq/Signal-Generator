package Client;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class UDPClient {
	private static DatagramSocket socket;
	private static int port = 8888;
	public static void main(String[] args) {
		byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
		try {
			InetAddress addr = InetAddress.getByName("localhost");
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
//			socket.close();
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

}
