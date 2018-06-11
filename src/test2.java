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
	    int p1 = 1;
            drawSine(p, a, w, h, g2);
	    drawSawtooth(g2, w, h, p1, 100);
	    //drawSquare(h,w, p1, 1, 1, g2);
            
       
            drawSquare();
            g2.setPaint(Color.red);
            g2.draw(wave);
	  
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	    JFrame frame = new JFrame();
	    frame.setSize(554, 378);
	    frame.setTitle("Graphs");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLocationRelativeTo(null);  
	    test2 draw = new test2();
	    frame.getContentPane().add(draw);
	    frame.setVisible(true);
	}
	public void drawSine(int freq, int amp, int w, int h, Graphics g2) {
		Polygon p1 = new Polygon();
		double y;
		for (int x =0; x <= w; x++) {
			y=h-amp*Math.sin(Math.PI*(float)(2*freq/1000.0*x/8.0));
			p1.addPoint(x+w,(int)y);
		}
		g2.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
		Polygon p2 = new Polygon();
		for (int x =0; x >= -w; x--) {
			y=h-amp*Math.sin(Math.PI*(float)(2*freq/1000.0*x/8.0));
			p2.addPoint(x+w,(int)y);
		}
		g2.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints); 
	}
	public void drawSawtooth(Graphics g2, int w, int h, int freq, int samplerate) {
		Polygon p1 = new Polygon();
		double y;
		for (int x = 0; x <= w; x++) {
			y=h-50*(x%(samplerate/(float)freq))/(samplerate/(float)freq);
                        
                       
			p1.addPoint(x+w, (int)y);
		}
		g2.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
                Polygon p2 = new Polygon();
		for (int x = 0; x >= -w; x--) {
			y=h-50*(x%(samplerate/(float)freq))/(samplerate/(float)freq);
			p2.addPoint(x+w, (int)y-50);
                        //System.out.println("x+w="+h);
            
		}
                
                g2.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);
                g2.drawLine(w, h-50, w, h);
               
	}
	/*public void drawSquare(int h, int w, int freq, int samplerate, int dutyCycle, Graphics g) {
		double scaler = (float)freq/(float)samplerate; 
		double shift = dutyCycle/20.0;
		Polygon p1 = new Polygon();
		double y;
		for (int x = 0; x < w; x++) {
			y = (h-(x * scaler + shift) % 1 )< dutyCycle ? 50f : 100f;
			p1.addPoint(x+w, (int)y);
                        //System.out.println("x="+y);
                      
		}
		g.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
               
	}*/
        private void drawSquare()
        {
            float w = getWidth();
            float h = getHeight();
            // totalWidth = steps * 2 * dx
            // dx = totalWidth/2*steps
            // for dx ~= 100
            float approxCycles = w/(2*100);
            // calculate dx to just fit wave into totalWidth (w-1)
            float dx = (w-1)/(int)Math.round(2*approxCycles);
            float dy = h/8;      // 100 for a wave height of 200
            float step = 1*dx;
            int steps = (int)(w/step);
            wave = new GeneralPath();
            float x = 0, y = h/2;
            wave.moveTo(x,y);
            for(int j = 0; j < steps; j++)
            {
                wave.lineTo(x,y-dy);
                x += dx;
                wave.lineTo(x,y-dy);
                wave.lineTo(x,y+dy);
                x += dx;
                wave.lineTo(x,y+dy);
                wave.lineTo(x,y);
            }
            // check fit
            //float total = steps*2*dx;
            //System.out.printf("steps = %d\nw-total = %.1f\n", steps, w-total);
        }
}

