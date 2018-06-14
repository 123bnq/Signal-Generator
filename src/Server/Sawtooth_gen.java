package Server;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;

public class Sawtooth_gen extends JComponent {
	int signal[];

	public Sawtooth_gen() {
		// TODO Auto-generated constructor stub
	}

	GeneralPath wave;

	public void paintComponent(Graphics g) {
		// w is x, and h is y (as in x/y values in a graph)
		int w = this.getWidth() / 2;
		int h = this.getHeight() / 2;
		signal = new int[w + 1];
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

		Graphics2D g3 = (Graphics2D) g;
		g3.setStroke(new BasicStroke(2));
		g3.setColor(Color.red);

		Polygon pol1 = new Polygon();
		drawSawtooth(w, h, 50, p1, 8000, p, signal);
		for (int i = 0; i <= w; i++) {
			pol1.addPoint(w + i, h - signal[i]);
		}

		g3.drawPolyline(pol1.xpoints, pol1.ypoints, pol1.npoints);
	}

	// public void drawSawtooth(int h, int w, int freq, Graphics2D g3){
	// freq=(freq+20)/20;
	// wave = new GeneralPath();
	// float approxCycles = freq*w/(150);
	// float dx = (w-1)/(float)Math.round(2*approxCycles);
	// float dy = h/4;
	// float step = 2*dx;
	// int steps = (int)(w*2/step);
	// float x = w, y = h;
	// wave.moveTo(x,y);
	// for(int j = 1; j < 2*steps; j++)
	// {
	// wave.lineTo(x+dx,y-dy);
	// x += dx;
	// wave.lineTo(x,y-dy);
	// wave.lineTo(x,y+dy);
	// }
	// g3.draw(wave);
	// }
	public void drawSawtooth(int w, int h, int n, int freq, int samplerate, int amp, int[] signal) {

		double y = 0;
		double sin;
		for (int x = 0; x <= w; x++) {
			y = 0;
			for (int j = 1; j < n; j++) {

				// sin=
				// -(double)(1/(double)j)*Math.pow(-1,j)*Math.sin(2*Math.PI*j*(double)(freq*x/8000));
				sin = -(double) (amp / (double) j) * Math.pow(-1, j)
						* Math.sin(2 * Math.PI * (double) j * (freq * (double) x / 8000));
				y = y + sin;
				// System.out.println(sin);
			}
			signal[x] = (int) y;
			// p1.addPoint(w+x,h-(int)y);
		}
	}
}
// public void drawSawtooth(Polygon p1, int w, int h, int freq, int samplerate,
// int amp) {
// double y;
// double xprev = 0.0;
// // for (int x = 0; x <= w; x++) {
// // y=h-amp*(x%(samplerate/(float)freq))/(samplerate/(float)freq);
// // pl.addPoint(x+w, (int)y);
// // }
// for (double t = 0; t < 6 * Math.PI; t += 0.005) {
// double x = 0.0;
// for (int i = 1; i <= w; i++) {
// x += Math.sin(i * t) / i;
// }
// x = x * 2 / Math.PI;
// p1.addPoint(w + (int) (t * 50), h + (int) (xprev * 100));
// xprev = x;
// }
// solution 1
// double y = 0.0;
// for (int i = 0; i < w; i++) {
// y =
// -2*amp/Math.PI*Math.atan(1/Math.tan(Math.PI*i*(double)freq/(double)samplerate));
// p1.addPoint(w+i, h-(int)Math.round(y));
// }
// }
// }
