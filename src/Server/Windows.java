package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Windows {

	private JFrame frmServerSignal;
	private JTextField IPAddr;
	private JTextField Port;
	
	private static Pattern IPPattern;
	private static Matcher IPMatcher;
	private static final String IP_ADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	private JLabel WarningIPaddr;
	private JLabel WarningPort;
	private JButton btnStartServer;
	private JButton btnStopServer;
	private TCPServer tcpserver;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windows window = new Windows();
					window.frmServerSignal.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Windows() {
		frmServerSignal = new JFrame();
		frmServerSignal.setTitle("Server - Signal generator");
		frmServerSignal.setBounds(100, 100, 400, 250);
		frmServerSignal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("Button.background"));
		frmServerSignal.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblIpAddress = new JLabel("IP Address:");
		lblIpAddress.setBounds(57, 42, 68, 14);
		desktopPane.add(lblIpAddress);
		
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(57, 98, 68, 14);
		desktopPane.add(lblPort);
		
		IPAddr = new JTextField();
		IPAddr.setToolTipText("for example: localhost or 192.168.137.1");
		IPAddr.setBounds(145, 39, 174, 20);
		desktopPane.add(IPAddr);
		IPAddr.setColumns(10);
		
		Port = new JTextField();
		Port.setToolTipText("from 1 to 65536");
		Port.setBounds(145, 95, 174, 20);
		desktopPane.add(Port);
		Port.setColumns(10);
		
		WarningIPaddr = new JLabel("");
		WarningIPaddr.setBounds(145, 70, 46, 14);
		desktopPane.add(WarningIPaddr);
		
		WarningPort = new JLabel("");
		WarningPort.setBounds(145, 126, 46, 14);
		desktopPane.add(WarningPort);
		
		btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addr = IPAddr.getText();
				System.out.println(addr+validateIPAddress(addr));
				boolean isLocalhost = IPAddr.getText().equals("localhost");
				if (isLocalhost | validateIPAddress(addr)) {
					tcpserver = new TCPServer(addr, Integer.parseInt(Port.getText()));
					tcpserver.start();
					IPAddr.setEditable(false);
					Port.setEditable(false);
				}
				else {
					IPAddr.setText("");
					Port.setText("");
				}
			}
		});
		btnStartServer.setBounds(57, 156, 105, 23);
		desktopPane.add(btnStartServer);
		
		btnStopServer = new JButton("Stop Server");
		btnStopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IPAddr.setEditable(true);
				Port.setEditable(true);
				tcpserver.stopServer();
				tcpserver.stop();
			}
		});
		btnStopServer.setBounds(230, 156, 105, 23);
		desktopPane.add(btnStopServer);
	}
	public boolean validateIPAddress(final String ipaddress) {
		IPPattern = Pattern.compile(IP_ADDRESS_PATTERN);
		IPMatcher = IPPattern.matcher(ipaddress);
		return IPMatcher.matches();
	}
	public boolean validatePort(final int portnum){
		return true;
	}
}

//ToggleServer.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		String addr = IPAddr.getText();
//		System.out.println(addr+validateIPAddress(addr));
//		boolean isLocalhost = IPAddr.getText().equals("localhost");
//		if(ToggleServer.isSelected()){
//			
//			if (isLocalhost | validateIPAddress(addr)) {
//				TCPServer tcpserver = new TCPServer(addr, Integer.parseInt(Port.getText()));
//				tcpserver.start();
//				IPAddr.setEditable(false);
//				Port.setEditable(false);
//			}
//			else {
//				IPAddr.setText("");
//				Port.setText("");
//			}
//		}
//		else {
//			
//			try {
//				TCPServer.pw.close();
//				TCPServer.bf.close();
//				TCPServer.socketObject.close();
//				TCPServer.server.close();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			IPAddr.setEditable(true);
//			Port.setEditable(true);
//			System.out.println("Clear Input\n");
//		}
//	}
//});