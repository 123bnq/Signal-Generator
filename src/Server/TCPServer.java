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
	public TCPServer(String Saddr, int port) {
		this.Saddr = Saddr;
		this.port = port;
	}
	public void run() {
		try {
			addr = InetAddress.getByName(Saddr);
			server = new ServerSocket(port, 1, addr);
			System.out.println("TCPServer start at " + Saddr+ " port " + port);
			while(true) {
				socketObject = server.accept();
				try {
					Thread.sleep(50);
				} catch (Exception e) {}
				pw = new PrintWriter(new OutputStreamWriter(socketObject.getOutputStream(), StandardCharsets.UTF_8), true);
				bf = new BufferedReader(new InputStreamReader(socketObject.getInputStream(), StandardCharsets.UTF_8));
				pw.println("Hello World");
				while (!bf.readLine().equals("1"));
				System.out.println("Client is connected");
			}
		}
		catch (SocketException se) {
				System.out.println("Server on port " + port + " is down!!!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("unknownHost");;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO");;
		}		
	}
	public void stopServer() {
		if (server != null) {
			shutdownServer(server);
		}
	}
	
	private void shutdownServer(ServerSocket server) {
		try {
			if (socketObject != null){
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
