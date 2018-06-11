import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;

public class Sawtooth_gen extends JComponent {

	public Sawtooth_gen() {
		// TODO Auto-generated constructor stub
	}
	public void paintComponent(Graphics g)
	{   
	     //w is x, and h is y (as in x/y values in a graph)
        int w = this.getWidth()/2;
	    int h = this.getHeight()/2;
	    
	    Graphics2D g1 = (Graphics2D) g;
	    g1.setStroke(new BasicStroke(2));
	    g1.setColor(Color.black);
	    g1.drawLine(0,h,w*2,h);
	    g1.drawLine(w,0,w,h*2); 
	    g1.drawString("0", w - 7, h + 13);
	    g1.setStroke(new BasicStroke(1));
	    g1.setColor(Color.gray);
	    for (int i = 1; i <= 3; i+=2) {
	    	g1.drawLine(0, i*h/2, w*2, i*h/2);
	    	g1.drawLine(i*w/2, 0, i*w/2, h*2);
	    }
//	    g1.drawLine(0, h-100, 2*w, h-100);
	
        super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(2));
	    g2.setColor(Color.red);
	  //line1
	//  Polygon p = new Polygon();
	//  for (int x = 0; x <= 4; x++) {
	//      p.addPoint(w+x, h - ((x*x*x) + x - 3));
	//
	//  }
	//  g2.drawPolyline(p.xpoints, p.ypoints, p.npoints);
	    int p = 100;
	    int a = 100;

	    int p1 = 600;
	    Polygon pol1 = new Polygon();
	    drawSawtooth(pol1, w, h, p1, 8000, p);
	    Graphics2D g3 = (Graphics2D) g;
	    g3.setStroke(new BasicStroke(2));
	    g3.setColor(Color.black);
	    g3.drawPolyline(pol1.xpoints, pol1.ypoints, pol1.npoints);
	}
	public void drawSawtooth(Polygon pl, int w, int h, int freq, int samplerate, int amp) {
//		double y;
		double xprev = 0.0;
//		for (int x = 0; x <= w; x++) {
//			y=h-amp*(x%(samplerate/(float)freq))/(samplerate/(float)freq);
//			pl.addPoint(x+w, (int)y);
//		}
		for (double t = 0; t < 6*Math.PI; t+=0.005) {
			double x = 0.0;
			for (int i = 1; i <= w; i++) {
				x+=Math.sin(i*t)/i;
			}
			x = x*2 /Math.PI;
			pl.addPoint(w+(int)(t*50), h+(int)(xprev*100));
			xprev = x;
		}
//		g2.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
//               
	}
}
