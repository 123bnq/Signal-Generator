package Server;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JComponent;

public class Graph extends JComponent {
	int[] signal;

	public Graph(int[] signal) {
		this.signal = signal;
	}

	public void paintComponent(Graphics g) {
		// w is x, and h is y (as in x/y values in a graph)
		int w = this.getWidth() / 2;
		int h = this.getHeight() / 2;
		Graphics2D g1 = (Graphics2D) g;
		g1.setStroke(new BasicStroke(2));
		g1.setColor(Color.black);
		g1.drawLine(0, h, w * 2, h);
		g1.drawLine(w, 0, w, h * 2);
		g1.drawString("0", w - 7, h + 13);
		g1.setStroke(new BasicStroke(1));
		g1.setColor(Color.gray);
		for (int i = 1; i <= 3; i += 2) {
			g1.drawLine(0, i * h / 2, w * 2, i * h / 2);
			g1.drawLine(i * w / 2, 0, i * w / 2, h * 2);
		}
		int p = 100; // amplitude
		int p1 = 100; // freq
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		g2.setColor(Color.red);

		Polygon pol1 = new Polygon();
		for (int i = 0; i < w; i++) {
			pol1.addPoint(w + i, h - signal[i]);
		}
		g2.drawPolyline(pol1.xpoints, pol1.ypoints, pol1.npoints);
	}
}
