package Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TCPClient {
	private static Socket socket;
	private static PrintWriter pw;
	private static BufferedReader bf;
	private static String addr = "localhost";
	
	public static void main(String[] args) {
		try {
			socket = new Socket(addr, 8888);
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			bf = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			System.out.println(bf.readLine());
			pw.println("1");
			pw.close();
			bf.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
