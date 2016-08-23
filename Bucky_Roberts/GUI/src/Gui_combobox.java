package buckysJGUI_tutorials;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Gui_combobox extends JFrame{
	
	private JComboBox box;
	private JLabel picture;
	
	private static String[] filename = {"a.png", "b.png"};
	private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])),new ImageIcon(getClass().getResource(filename[1]))};
	
	public Gui_combobox(){
		super("The Title");
		setLayout(new FlowLayout());
		
		box = new JComboBox(filename);
		box.addItemListener(
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange() == ItemEvent.SELECTED)
							picture.setIcon(pics[box.getSelectedIndex()]);
					}
				}				
		);
		
		add(box);
		picture = new JLabel(pics[0]);
		
	}
	

}
