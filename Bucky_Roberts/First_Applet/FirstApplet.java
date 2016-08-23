import java.awt.*;
import javax.swing.*;


public class FirstApplet extends JApplet {
        private double sum;

        public void init(){
                String fn;
                String sn;
                fn = JOptionPane.showInputDialog("EnterThe first Number ");
                double n1 = Double.parseDouble(fn);
                sn = JOptionPane.showInputDialog("EnterThe Second Number ");
                double n2 = Double.parseDouble(sn);
                sum = n1 + n2;
        }

        public void paint(Graphics g){
                super.paint(g);
                g.drawString("The Sum is " + sum, 25, 25);
        }
        //	Some kind of first work:
        //	public void paint(Graphics g){
        //		super.paint(g);
        //		g.drawString("Wow thisis Actually WOKRES!", 25,25);
        //	}
}
