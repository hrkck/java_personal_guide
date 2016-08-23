import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class ReadFile extends JFrame {
        private JTextField addressBar;
        private JEditorPane display;

        // Constructor
        public ReadFile(){
                super("THE MINI-BROWSER");

                addressBar = new JTextField("Enter A URL BUDDY!");
                addressBar.addActionListener(
                        new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent event) {
                                        loadCrap(event.getActionCommand());
                                }
                        }
                                            );
                add(addressBar, BorderLayout.NORTH);

                display = new JEditorPane();
                display.setEditable(false);
                display.addHyperlinkListener(
                        new HyperlinkListener() {
                                @Override
                                public void hyperlinkUpdate(HyperlinkEvent event) {
                                        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                                                loadCrap(event.getURL().toString());
                                        }
                                }
                        }
                                            );
                add(new JScrollPane(display), BorderLayout.CENTER);
                setSize(500, 300);
                setVisible(true);
        }

        // Load Crap to display on Screen
        private void loadCrap(String userText){
                try {
                        display.setPage(userText);
                        addressBar.setText(userText);
                } catch (Exception e) {
                        System.out.println("Crawp!");
                }
        }
}
