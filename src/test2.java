import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class test2 extends JComponent {
	public test2() {
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
	    int p = 50;
	    int a = 200;
	//  drawSine(p, a, w, h, g2);
	    drawSawtooth(g2, w, h, p);
	
	  
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	    JFrame frame = new JFrame();
	    frame.setSize(800, 600);
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
	public void drawSawtooth(Graphics g2, int w, int h, int freq) {
		Polygon p1 = new Polygon();
		double y;
		for (int x = 0; x <= w; x++) {
			y=h-(x-Math.abs(x));
			p1.addPoint(x, (int)y);
		}
		g2.drawPolyline(p1.xpoints, p1.ypoints, p1.npoints);
		Polygon p2 = new Polygon();
		for (int x = 0; x >= -w; x--) {
			y=h-(x-Math.abs(x));
			p2.addPoint(x, (int)y);
		}
		g2.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);
		
	}
}

