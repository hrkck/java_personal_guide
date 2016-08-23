package buckysJGUI_tutorials;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Gui_button extends JFrame {
        /**
         *
         */
        private static final long serialVersionUID = 3635858001696630971L;
        private JButton reg;
        private JButton custom;

        public Gui_button() {
                super("The Title");
                setLayout(new FlowLayout());

                reg = new JButton("reg Button");
                add(reg);

                Icon b = new ImageIcon(getClass().getResource("a.png"));
                Icon x = new ImageIcon(getClass().getResource("b.png"));
                custom = new JButton("Custom", b);
                custom.setRolloverIcon(x);
                add(custom);

                HandlerClass handler = new HandlerClass();
                reg.addActionListener(handler);
                custom.addActionListener(handler);
        }

        private class HandlerClass implements ActionListener {
                public void actionPerformed(ActionEvent event) {
                        JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
                }
        }
}
