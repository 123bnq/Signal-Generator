import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;

import javax.swing.JComponent;

public class Square_gen extends JComponent {

	public Square_gen() {
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
            int Duty_Cycle=100;
           
	    //drawSquare(h,w, p1, 1, 1, g2);
            drawSquare(h,w,Duty_Cycle,g2);
        
            
            //drawSquare();
            //g2.setPaint(Color.red); 
	}
        public void drawSquare(int h, int w, int Duty_Cycle, Graphics2D g2){
            float approxCycles = w/(100);
            float dx = (w-1)/(int)Math.round(2*approxCycles);
            float dy = h/8;
            float step = 2*dx;
            int steps = (int)(w*2/step);
            wave = new GeneralPath();
            float x = w, y = h;
            wave.moveTo(x,y);
            for(int j = 0; j < steps; j++)
            {
                wave.lineTo(x,y-dy);
                x += dx;
                wave.lineTo(x-50+Duty_Cycle,y-dy);
                wave.lineTo(x-50+Duty_Cycle,y+dy);
                x += dx;
                wave.lineTo(x,y+dy);
                wave.lineTo(x,y);
            }
            g2.draw(wave);
          
        }
}
