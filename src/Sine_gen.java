import java.awt.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;

public class Sine_gen extends JComponent {

	public Sine_gen() {

	}
    GeneralPath wave;
        
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
	
            super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(2));
	    g2.setColor(Color.black);

	    int p = 100;
	    int a = 100;


	    Polygon pol = new Polygon();
            drawSine(pol, p, a, w, h);
            g2.drawPolyline(pol.xpoints, pol.ypoints, pol.npoints);
            g2.setColor(Color.BLACK);


	 
	}
	public void drawSine(Polygon p1, int freq, int amp, int w, int h) {
		double y;
		for (int x =0; x <= w; x++) {
			y=h-amp*Math.sin(Math.PI*(float)(2*freq*x/8000.0));
			p1.addPoint(x+w,(int)y);
		}
	}

}
