/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertictactoe;



import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import static servertictactoe.Database.serverPlayerList;

/**
 *
 * @author ميناناجحعبدالمسيحزكى
 */
public class PlayerHandler extends Thread {
    
 DataInputStream dis;
 PrintStream ps;  
    private String username;
    private String email;
    private String password;
    private String status;
    private int totalScore;
    private int numPlayedGames;
 static Vector<PlayerHandler> players = new Vector<PlayerHandler>();
   
 public void refreshServerList()
 {
     Platform.runLater(() -> {
         try {
             serverPlayerList();
         } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
             Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
         }
     });
 }
 
 public PlayerHandler(Socket cs)
{
     try {
         dis = new DataInputStream(cs.getInputStream());
         ps = new PrintStream(cs.getOutputStream());
         PlayerHandler.players.add(this);
         start();
     } catch (IOException ex) {
        ex.printStackTrace();
     }
}
 
public void run()
{
while(true)
{
    try {
        String completeMsg = dis.readUTF();
        StringTokenizer tokenizer = new StringTokenizer("completeMsg",";");
        
        String header = tokenizer.nextToken();
        switch (header){
            case "request" :
                
                break;
            case "login":
                break;
            case "signup":
                break;
            default:
                break;
        } } catch (IOException ex) {
        Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}
 
 
 private void sendRequest(String sender , String reciever){
     for(int i = 0 ; i< players.size();i++){
         if(players.get(i).username.equals(reciever) && players.get(i).status.equals("online")){
         
             players.get(i).ps.println("request;"+sender+reciever);
         }
     
     }
     
 }

 
 
    
}