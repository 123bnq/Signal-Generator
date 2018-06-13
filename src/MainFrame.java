import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	test2 draw = new test2();
	Sine_gen sin = new Sine_gen();
	Sawtooth_gen saw = new Sawtooth_gen();
	Square_gen square = new Square_gen();
	private final JPanel panel = new JPanel();
	private final JButton sin_btn = new JButton("New button");
	private final JButton sawtooth_btn = new JButton("New button");
	private final JButton square_btn = new JButton("New button");
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		panel_1.setBackground(Color.white);panel_1.add(sin);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		
		//contentPane.add(sin);
//		contentPane.add(draw);
//		contentPane.add(saw);
<<<<<<< HEAD
//		contentPane.add(square);
=======
		contentPane.add(square);

>>>>>>> e75e31ca304c943474f96fc05fb0715c22606571
		
		contentPane.add(panel, BorderLayout.SOUTH);
		sin_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				contentPane.removeAll();
//				Sine_gen sin = new Sine_gen();
//				panel_1.add(sin);
			}
		});
		
		panel.add(sin_btn);
		sawtooth_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				contentPane.removeAll();
				contentPane.add(saw);
			}
		});
		
		panel.add(sawtooth_btn);
		square_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				contentPane.removeAll();
				contentPane.add(square);
			}
		});
		
		panel.add(square_btn);
//		contentPane.removeAll();
//		contentPane.add(sin);
	}

}