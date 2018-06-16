package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Server.Graph;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.sound.sampled.Port;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ClientWindowMain extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField IPAddrField;
	private JTextField PortField;
	private static TCPClient tcp;
	private UDPClient udp;
	private static Thread tcpThread;
	private static Thread udpThread;
	private static Pattern IPPattern;
	private static Matcher IPMatcher;
	private static final String IP_ADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	private JButton btnConnect;
	private JButton btnDisconnect;

	private static Display dsp;
	private ClientWindowMain cl;
	Thread t;

	private static JFrame frame;
	private int w = 400;
	private int h = 300;

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
					ClientWindowMain frame = new ClientWindowMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientWindowMain() {
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		IPAddrField = new JTextField();
		IPAddrField.setToolTipText("for example: localhost or 192.168.137.1");
		IPAddrField.setText("localhost");
		IPAddrField.setBounds(172, 70, 154, 20);
		contentPane.add(IPAddrField);
		IPAddrField.setColumns(10);

		JLabel lblNewLabel = new JLabel("IP Address");
		lblNewLabel.setBounds(82, 73, 80, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Port");
		lblNewLabel_1.setBounds(82, 137, 46, 14);
		contentPane.add(lblNewLabel_1);

		PortField = new JTextField();
		PortField.setToolTipText("from 1 to 65535");
		PortField.setText("8888");
		PortField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if ((key >= e.VK_0 && key <= e.VK_9) || (key >= e.VK_NUMPAD0 && key <= e.VK_NUMPAD9)
						|| key == e.VK_BACK_SPACE) {
					PortField.setEditable(true);
					// WarningPort.setText("");
				} else {
					PortField.setEditable(false);
					// WarningPort.setText("Only number is accepted");
				}
			}
		});
		PortField.setBounds(172, 134, 154, 20);
		contentPane.add(PortField);
		PortField.setColumns(10);

		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String IPaddr = IPAddrField.getText();
				int port = Integer.parseInt(PortField.getText());
				boolean isPort;
				if (port >= 0 && port < 65536) {
					isPort = true;
				} else
					isPort = false;
				boolean isLocalhost = IPaddr.equals("localhost");
				if ((isLocalhost | validateIPAddress(IPaddr)) && isPort) {
					// tcp = new TCPClient(IPaddr, port);
					// tcpThread = new Thread(tcp);
					// tcpThread.start();
					// udp = new UDPClient(IPaddr, port);
					// udpThread = new Thread(udp);
					// udpThread.start();
					// dsp = new Display(tcp, udp);
					cl = new ClientWindowMain();
					t = new Thread(cl);
					t.start();
					IPAddrField.setEditable(false);
					PortField.setEditable(false);
					btnDisconnect.setEnabled(true);
					btnConnect.setEnabled(false);
				} else {
					IPAddrField.setText("");
					IPAddrField.setEditable(true);
					PortField.setText("");
					PortField.setEditable(true);
				}
			}
		});
		btnConnect.setBounds(99, 199, 89, 23);
		contentPane.add(btnConnect);

		btnDisconnect = new JButton("Disconnect");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConnect.setEnabled(true);
				IPAddrField.setEditable(true);
				PortField.setEditable(true);
				tcp.closeConnection();
//				udp.closeConnection();
				btnDisconnect.setEnabled(false);
				dsp.setVisible(false);
				if (frame != null) {
					frame.setVisible(false);
					frame = null;
				}
				t.stop();
			}
		});
		btnDisconnect.setBounds(237, 199, 89, 23);
		btnDisconnect.setEnabled(false);
		contentPane.add(btnDisconnect);
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
		System.out.println("Start Connection");
		tcp = new TCPClient(IPAddrField.getText(), Integer.parseInt(PortField.getText()), w, h);
		tcpThread = new Thread(tcp);
		tcpThread.start();
		udp = new UDPClient(IPAddrField.getText(), Integer.parseInt(PortField.getText()));
		System.out.println("UDP version: " + udp.counter);
		udpThread = new Thread(udp);
		udpThread.start();
		dsp = new Display(tcp, udp);
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (udp.isReceived()) {
				if (frame != null) {
					frame.dispose();
					frame = null;
					System.out.println("Frame is null: " + (frame == null));
				}
				if (frame == null) {
					frame = new JFrame();
				}
				frame.setSize(w*2, h*2);
				frame.setTitle("Graphs");
				int[] signal = udp.getSignal();
				System.out.print("Display: ");
				for (int i = 0; i < signal.length; i++) {
					System.out.print(signal[i] + " ");
				}
				System.out.println();
				frame.getContentPane().add(new Graph(signal));
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				udp.setReceived(false);
			}
		}
	}
}
