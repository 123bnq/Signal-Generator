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

            int freq=100; //freq of Sawtooth 1~100
	
            super.paintComponent(g);
	   

            Graphics2D g3 = (Graphics2D) g;
	    g3.setStroke(new BasicStroke(2));
	    g3.setColor(Color.red);
            
            drawSawtooth(h,w,freq,g3);
	}
	public void drawSawtooth(int h, int w, int freq, Graphics2D g3){
            freq=(freq+20)/20;
            wave = new GeneralPath();
            float approxCycles = freq*w/(150);
            float dx = (w-1)/(float)Math.round(2*approxCycles);
            float dy = h/4;
            float step = 2*dx;
            int steps = (int)(w*2/step);
                 float x = w, y = h;
            wave.moveTo(x,y);
            for(int j = 1; j < 2*steps; j++)
            {
                wave.lineTo(x+dx,y-dy);
                x += dx;
                wave.lineTo(x,y-dy);
                wave.lineTo(x,y+dy);
            }
            g3.draw(wave);
        }
}
