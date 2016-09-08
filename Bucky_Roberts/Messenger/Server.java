import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {

  private JTextField userText;
  private JTextArea chatWindow;
  private ObjectOutputStream output; // to recieve data
  private ObjectInputStream input; // to send data
  private ServerSocket server;
  private Socket connection;

  // constructor
  public Server(){
    super("Instant Messenger");

    userText = new JTextField();
    userText.setEditable(false);
    // To send the text to client:
    userText.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent event){
          sendMessage(event.getActionCommand());
          userText.setText("");
        }
      }
    );

    // Adding things to the GUI:
    add(userText, BorderLayout.NORTH);
    chatWindow = new JTextArea();
    add(new JScrollPane(chatWindow));
    setSize(600, 300);
    setVisible(true);
  }

  // set up and run the server
  public void startRunning(){
    try{
      server = new ServerSocket(8888, 100);
      while(true){
        try{
          // connect and have conversation
          acceptConnection();
          setupStreams();
          whileChatting();
        }catch(EOFException eofException){
          showMessage("Server ends the connection!");
        }finally{
          closeConnection();
        }
      }
    }catch(IOException ioException){
      ioException.printStackTrace();
    }
  }

  // Wait fo connection, then display information
  private void acceptConnection() throws IOException{
    showMessage("Waiting for someone to connect... \n");
    connection = server.accept();
    String ipAddress = connection.getInetAddress().getHostName();
    showMessage("Now connected to " + ipAddress );
  }

  // get streams to send and recieve data
  private void setupStreams() throws IOException{
    output = new ObjectOutputStream(connection.getOutputStream());
    output.flush();
    input = new ObjectInputStream(connection.getInputStream());
    showMessage("Streams are now setup! \n");
  }

  // during the chat conversation
  private void whileChatting() throws IOException{
    String message = "Your are now connected!\n";
    sendMessage(message);
    abletoType(true);
    do {
      try{
        message = (String) input.readObject();
        showMessage(message);
      }catch(ClassNotFoundException classNotFoundException){
        showMessage("Could not recieve input from Client");
      }
    } while (!message.equals("CLIENT: END"));
  }

  // close Streams and Socket
  private void closeConnection(){
    showMessage("Closing connections...");
    abletoType(false);
    try{
      output.close();
      input.close();
      connection.close();
    }catch(IOException ioException){
      ioException.printStackTrace();
    }
  }

  // send message to Client
  private void sendMessage(String message){
    try{
      output.writeObject("SERVER: " + message);
      output.flush();
      showMessage("SERVER: " + message);
    }catch(IOException ioException){
      showMessage("ERROR: Can't send the message");
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
