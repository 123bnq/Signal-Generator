import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JFrame;
        
public class Drawing extends JFrame {
    int x,y;
    public Drawing(){
        setTitle("Drawing");
        setSize(544, 378);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paint(Graphics g){
        g.drawLine(272, 0, 272, 350); //y ax is
        g.drawLine(50, 176, 490, 176); // x axis
        g.setColor(Color.red);
        g.fillOval(x, y, 3, 3);
        
    }
    
    public static void main(String[] args){
        new Drawing();
    }
    
}
