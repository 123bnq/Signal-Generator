import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.geom.GeneralPath;

public class test2 extends JComponent {
	public test2() {

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
            int p = 100; //freq of Sine Freq 1~100
	    int a = 100; // Amplitude of Sine
     
	    //int p1 = 1; 
            int Duty_Cycle=50; // Duty_Cycle of Square  Duty run 1~100
            
            int freq=100; //freq of Sawtooth 1~100
	
            super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(2));
	    g2.setColor(Color.black);
            
            
         

	   
	    
            Polygon pol = new Polygon();
            drawSine(pol, p, a, w, h);
            g2.drawPolyline(pol.xpoints, pol.ypoints, pol.npoints);
            g2.setColor(Color.blue);
            
            drawSquare(h,w,Duty_Cycle,g2);
            
            Graphics2D g3 = (Graphics2D) g;
	    g3.setStroke(new BasicStroke(2));
	    g3.setColor(Color.red);
            
            drawSawtooth(h,w,freq,g3);
        
           
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	    JFrame frame = new JFrame();
	    frame.setSize(776, 471);
	    frame.setTitle("Graphs");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);  
	    test2 draw = new test2();
	    frame.getContentPane().add(draw);
	    frame.setVisible(true);
	}
	public void drawSine(Polygon p1, int freq, int amp, int w, int h) {
		double y;
		for (int x =0; x <= w; x++) {
			y=h-amp*Math.sin(Math.PI*(float)(2*(freq+20)/20*x/95.0));
			p1.addPoint(x+w,(int)y);
		}
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

        public void drawSquare(int h, int w, int Duty_Cycle, Graphics2D g2){
            float approxCycles = w/(95);
            float dx = (w-1)/(float)Math.round(2*approxCycles);
            float dy = h/2;
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

