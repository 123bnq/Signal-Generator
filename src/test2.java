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
<<<<<<< HEAD
	    int p1 = 600;
	    Polygon pol = new Polygon();
        drawSine(pol, p, a, w, h);
        g2.drawPolyline(pol.xpoints, pol.ypoints, pol.npoints);
        g2.setColor(Color.BLACK);
//        super.paintComponent(g1);
//        g2 = (Graphics2D)g;
	    Polygon pol1 = new Polygon();
	    drawSawtooth(pol1, w, h, p1, 8000, p);
	    Graphics2D g3 = (Graphics2D) g;
	    g3.setStroke(new BasicStroke(2));
	    g3.setColor(Color.black);
	    g3.drawPolyline(pol1.xpoints, pol1.ypoints, pol1.npoints);
	    //drawSquare(h,w, p1, 1, 1, g2);
	    drawSquare();
//        g2.setPaint(Color.red);
        g2.draw(wave);
//      g2.clearRect(0, 0, w, h);
=======
	    int p1 = 1;
            int Duty_Cycle=100;
            drawSine(p, a, w, h, g2);
	    drawSawtooth(g2, w, h, p1, 100);
	    //drawSquare(h,w, p1, 1, 1, g2);
            drawSquare(h,w,Duty_Cycle,g2);
        
            
            //drawSquare();
            //g2.setPaint(Color.red);
         
>>>>>>> 94d4cddb7a0fa412dd37083e2b2d7b1aae4c8125
	  
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
	public void drawSine(Polygon p1, int freq, int amp, int w, int h) {
		double y;
		for (int x =0; x <= w; x++) {
			y=h-amp*Math.sin(Math.PI*(float)(2*freq*x/8000.0));
			p1.addPoint(x+w,(int)y);
		}
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
        /*private void drawSquare()
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
            float step = 2*dx;
            int steps = (int)(w/step);
            wave = new GeneralPath();
            float x = w/2, y = h/2;
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
        */
        
}

