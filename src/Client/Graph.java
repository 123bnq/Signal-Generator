package Client;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JComponent;

public class Graph extends JComponent {
	int[] signal;
	int originX;
	int originY;
	int border;
	int spacingY = 20;
	int spacingX = 15;

	public Graph(int[] signal, int border) {
		this.signal = signal;
		this.border = border;
	}

	public void paintComponent(Graphics g) {
		// w is x, and h is y (as in x/y values in a graph)
		int w = this.getWidth() / 2;
		int h = this.getHeight() / 2;
		originX = border;
		originY = h;
		Graphics2D g1 = (Graphics2D) g;
		g1.setFont(new Font(g1.getFont().getName(), g1.getFont().getStyle(), 15));
		g1.setStroke(new BasicStroke(2));
		g1.setColor(Color.black);
		g1.drawLine(originX, originY, w * 2 - border, originY); // x axis
		g1.drawLine(originX, border, originX, h * 2 - border); // y axis
		g1.drawString("0", originX - spacingX, originY + spacingY);
		g1.drawString("ms", w * 2 - border - spacingX, originY + spacingY);
		g1.setStroke(new BasicStroke(1));
		g1.setColor(Color.gray);
		for (int i = 1; i < 3; i++) {
			g1.drawLine(originX, originY + 100 * i, w * 2 - border, originY + 100 * i);
			g1.drawLine(originX, originY - 100 * i, w * 2 - border, originY - 100 * i);
		}
		for (int i = 1; i <= 10; i++) {
			g1.drawLine(i * 80 + originX, border, i * 80 + originX, h * 2 - border);
		}
		g1.setColor(Color.black);
		for (int i = 2; i <= 10; i += 2) {
			g1.drawString(Integer.toString(i * 10), originX + i * 80 - spacingX, originY + spacingY);
		}
		for (int i = 1; i < 3; i++) {
			g1.drawString(Integer.toString(i * 100), originX - 2 * spacingX, originY + 100 * i + 5);
			g1.drawString(Integer.toString(i * -100), originX - 2 * spacingX, originY - 100 * i + 5);
		}

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.red);

		Polygon pol1 = new Polygon();
		for (int i = 0; i < 800; i++) {
			pol1.addPoint(originX + i, originY - signal[i]);
		}
		g2.drawPolyline(pol1.xpoints, pol1.ypoints, pol1.npoints);
	}
}
