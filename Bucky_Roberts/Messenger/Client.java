import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame{

  private JTextField userText;
  private JTextArea chatWindow;
  private ObjectOutputStream output;
  private ObjectInputStream input;
  private String message = "";
  private String serverIP;
  private Socket connection;

  public Client(String host){
    super("Client Instant Messenger");
    serverIP = host;
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
    add(new JScrollPane(chatWindow), BorderLayout.CENTER);
    setSize(600,300);
    setVisible(true);
  }

  // connect to server
  public void startRunning(){
    try{
      connectToServer();
      setupStreams();
      whileChatting();
    }catch(EOFException eofException){
      showMessage("Client terminated connection");
    }catch(IOException ioException){
      ioException.printStackTrace();
    }finally{
      closeConnection();
    }
  }

  // connect to server
  private void connectToServer() throws IOException{
    showMessage("Attempting Connection... \n");
    connection = new Socket(InetAddress.getByName(serverIP), 8888);
    String ipAddress = connection.getInetAddress().getHostName();
    showMessage("Now connected to " + ipAddress );
  }

  // set up streams to send and receive messages
  private void setupStreams() throws IOException{
    output = new ObjectOutputStream(connection.getOutputStream());
    output.flush();
    input = new ObjectInputStream(connection.getInputStream());
    showMessage("Streams are good to go.");
  }

  // while chatting with server
  private void whileChatting() throws IOException{
    abletoType(true);
    do {
      try{
        message = (String) input.readObject();
        showMessage(message);
      }catch(ClassNotFoundException classNotFoundException){
        showMessage("Could not recieve message from the Server");
      }
    } while (!message.equals("SERVER: END"));
  }

  // Close Streams and Sockets
  private void closeConnection(){
    showMessage("Closing Streams and Sockets down...");
    abletoType(false);
    try{
      output.close();
      input.close();
      connection.close();
    }catch(IOException ioException){
      ioException.printStackTrace();
    }
  }

  // Send messages to the Server
  private void sendMessage(String message){
    try{
      output.writeObject("CLIENT: " + message);
      output.flush();
      showMessage("CLIENT: " + message);
    }catch(IOException ioException){
      chatWindow.append("Could not send message to the Server");
    }
  }

  // updates chatWindow
  private void showMessage(final String message){
    SwingUtilities.invokeLater(
      new Runnable(){
        public void run(){
          chatWindow.append("\n" + message);
        }
      }
    );
  }

  // Changing userText's editability
  private void abletoType(final boolean bool){
    SwingUtilities.invokeLater(
      new Runnable(){
        public void run(){
          userText.setEditable(bool);
        }
      }
    );
  }
}
