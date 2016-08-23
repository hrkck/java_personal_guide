package buckysJGUI_tutorials;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gui_List extends JFrame {
        private JList list;
        private static String[] colornames = {"black", "blue", "red", "white"};
        private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE};

        public Gui_List() {
                super("The Title");
                setLayout(new FlowLayout());

                list = new JList(colornames);
                list.setVisibleRowCount(4);
                list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                add(new JScrollPane(list));

                list.addListSelectionListener(
                        new ListSelectionListener() {
                                public void valueChanged(ListSelectionEvent e) {
                                        getContentPane().setBackground(colors[list.getSelectedIndex()]);
                                }
                        }
                                             );
        }
}
