import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Server extends JFrame {
        private JTextField userText;
        private JTextArea chatWindow;
        private ObjectOutputStream output;
        private ObjectInputStream input;
        private ServerSocket server;
        private Socket connection;

        public Server {
                super("Server-Client Apps To Chat each other");
                userText = new JTextField();
                userText.setEditable(false);
                userText.addActionListener(
                        new ActionListener(){
                                public void actionPerformed(ActionEvent event){
                                        sendMessage(event.getActionCommand());
                                        userText.setText("");
                                }
                        }
                                          );
                add(userText, BorderLayout.NORTH);
                chatWindow = new JTextArea();
                add(new JScrollPane(chatWindow));
                setSize(500, 250);
                setVisible(true);
        }

        // Setup and Run the Server
        public void start_running(){
                try {
                        server = new ServerSocket(6789, 100);
                } catch (IOException ioE) {
                        ioE.printStackTrace();
                }
        }
}
