package buckysJGUI_tutorials;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gui_checkbox extends JFrame {
        private JTextField tf;
        private JCheckBox boldbox;
        private JCheckBox italicbox;
        public Gui_checkbox(){
                super("The title");
                setLayout(new FlowLayout());

                tf = new JTextField("This is a sentece", 20);
                tf.setFont(new Font("Serif", Font.PLAIN, 14));
                add(tf);

                boldbox = new JCheckBox("bold");
                italicbox = new JCheckBox("italic");
                add(boldbox);
                add(italicbox);

                HandlerClass handler = new HandlerClass();
                boldbox.addItemListener(handler);
                italicbox.addItemListener(handler);
        }

        private class HandlerClass implements ItemListener {
                @Override
                public void itemStateChanged(ItemEvent e) {
                        Font font = null;

                        if (boldbox.isSelected() && italicbox.isSelected()) {
                                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
                        } else if (boldbox.isSelected()) {
                                font = new Font("Serif", Font.BOLD, 14);
                        } else if (italicbox.isSelected()) {
                                font = new Font("Serif", Font.ITALIC, 14);
                        } else {
                                font = new Font("Serif", Font.PLAIN, 14);
                        }
                        tf.setFont(font);
                }
        }
}
