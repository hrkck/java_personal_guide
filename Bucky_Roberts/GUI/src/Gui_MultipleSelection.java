package buckysJGUI_tutorials;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gui_MultipleSelection extends JFrame {

	private JList leftlist;
	private JList rightlist;
	private JButton movebutton;
	private static String[] foods = { "bacon", "wings", "ham", "beef" };
	
	public Gui_MultipleSelection(){
		super("The Title");
		setLayout(new FlowLayout());
		
		leftlist = new JList(foods);
		leftlist.setVisibleRowCount(3);
		leftlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(leftlist));
		
		movebutton = new JButton("Move --> ");
		movebutton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rightlist.setListData(leftlist.getSelectedValues());
					}
				}
		);
		add(movebutton);
		
		rightlist = new JList();
		rightlist.setVisibleRowCount(3);
		rightlist.setFixedCellWidth(100);
		rightlist.setFixedCellHeight(10);
		rightlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(rightlist));
		
	}
}
