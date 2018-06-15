package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.chrono.IsoChronology;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Windows implements Runnable {

	private JFrame frmServerSignal;
	private JTextField IPAddr;
	private JTextField Port;

	private static Pattern IPPattern;
	private static Matcher IPMatcher;
	private static final String IP_ADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	private JLabel WarningIPaddr;
	private JLabel WarningPort;
	private JButton btnStartServer;
	private JButton btnStopServer;
	private static TCPServer tcpserver;
	private static UDPServer udpserver;
	private static Thread tcpthread, udpthread;

	private Windows win;
	Thread t;
	private String addr;
	private int port;

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
		// EventQueue.invokeLater(win);
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

		WarningIPaddr = new JLabel("");
		WarningIPaddr.setBounds(145, 70, 46, 14);
		desktopPane.add(WarningIPaddr);

		WarningPort = new JLabel("");
		WarningPort.setBounds(145, 126, 229, 14);
		desktopPane.add(WarningPort);

		JLabel lblIpAddress = new JLabel("IP Address:");
		lblIpAddress.setBounds(57, 42, 68, 14);
		desktopPane.add(lblIpAddress);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(57, 98, 68, 14);
		desktopPane.add(lblPort);

		IPAddr = new JTextField();
		IPAddr.setText("localhost");
		IPAddr.setToolTipText("for example: localhost or 192.168.137.1");
		IPAddr.setBounds(145, 39, 174, 20);
		desktopPane.add(IPAddr);
		IPAddr.setColumns(10);

		Port = new JTextField();
		Port.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if ((key >= e.VK_0 && key <= e.VK_9) || (key >= e.VK_NUMPAD0 && key <= e.VK_NUMPAD9)
						|| key == e.VK_BACK_SPACE) {
					Port.setEditable(true);
					WarningPort.setText("");
				} else {
					Port.setEditable(false);
					WarningPort.setText("Only number is accepted");
				}
			}
		});
		Port.setText("8888");
		Port.setToolTipText("from 1 to 65535");
		Port.setBounds(145, 95, 174, 20);
		desktopPane.add(Port);
		Port.setColumns(10);

		btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addr = IPAddr.getText();
				port = Integer.parseInt(Port.getText());
				boolean isPort;
				if (port >= 0 && port < 65536) {
					isPort = true;
				} else
					isPort = false;
				System.out.println(addr + validateIPAddress(addr));
				boolean isLocalhost = addr.equals("localhost");
				if ((isLocalhost | validateIPAddress(addr)) && isPort) {
					// tcpserver = new TCPServer(addr, port);
					// System.out.println(tcpserver == null);
					// tcpthread = new Thread(tcpserver);
					// tcpthread.start();
					// udpserver = new
					// UDPServer(Integer.parseInt(Port.getText()));
					// udpthread = new Thread(udpserver);
					// udpthread.start();
					IPAddr.setEditable(false);
					Port.setEditable(false);
					btnStopServer.setEnabled(true);
					btnStartServer.setEnabled(false);
					win = new Windows();
					t = new Thread(win);
					t.start();
				} else {
					IPAddr.setText("");
					IPAddr.setEditable(true);
					Port.setText("");
					Port.setEditable(true);
				}
			}
		});
		btnStartServer.setBounds(57, 156, 105, 23);
		desktopPane.add(btnStartServer);

		btnStopServer = new JButton("Stop Server");
		btnStopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStartServer.setEnabled(true);
				IPAddr.setEditable(true);
				Port.setEditable(true);
				tcpserver.stopServer();
				udpserver.shutdownServer();
				btnStopServer.setEnabled(false);
				t.stop();
//				tcpthread.stop();
//				udpthread.stop();
			}
		});
		btnStopServer.setBounds(230, 156, 105, 23);
		btnStopServer.setEnabled(false);
		desktopPane.add(btnStopServer);
	}

	public boolean validateIPAddress(final String ipaddress) {
		IPPattern = Pattern.compile(IP_ADDRESS_PATTERN);
		IPMatcher = IPPattern.matcher(ipaddress);
		return IPMatcher.matches();
	}

	public boolean validatePort(final int portnum) {
		return true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		tcpserver = new TCPServer(IPAddr.getText(), Integer.parseInt(Port.getText()));
		System.out.println(tcpserver == null);
		tcpthread = new Thread(tcpserver);
		tcpthread.start();
		udpserver = new UDPServer(Integer.parseInt(Port.getText()));
		udpthread = new Thread(udpserver);
		udpthread.start();
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (tcpserver != null) {
				if (tcpserver.isConnected()) {
					if (tcpserver.isFinished()) {
						udpserver.setSignal(tcpserver.getSignal());
						udpserver.setSignalName(tcpserver.getSignalName());
						udpserver.setFinished(tcpserver.isFinished());
						tcpserver.setFinished(false);
						System.out.println("finished");
					} else {
//						System.out.println("not finished");
					}
				}
			}
		}
	}
}

// ToggleServer.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// String addr = IPAddr.getText();
// System.out.println(addr+validateIPAddress(addr));
// boolean isLocalhost = IPAddr.getText().equals("localhost");
// if(ToggleServer.isSelected()){
//
// if (isLocalhost | validateIPAddress(addr)) {
// TCPServer tcpserver = new TCPServer(addr, Integer.parseInt(Port.getText()));
// tcpserver.start();
// IPAddr.setEditable(false);
// Port.setEditable(false);
// }
// else {
// IPAddr.setText("");
// Port.setText("");
// }
// }
// else {
//
// try {
// TCPServer.pw.close();
// TCPServer.bf.close();
// TCPServer.socketObject.close();
// TCPServer.server.close();
// } catch (IOException e1) {
// // TODO Auto-generated catch block
// e1.printStackTrace();
// }
// IPAddr.setEditable(true);
// Port.setEditable(true);
// System.out.println("Clear Input\n");
// }
// }
// });