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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static servertictactoe.Database.onlinePlayerList;
import static servertictactoe.Database.serverPlayerList;
import static sun.audio.AudioPlayer.player;

/**
 *
 * @author ميناناجحعبدالمسيحزكى
 */
public class PlayerHandler extends Thread {
    
 DataInputStream dis;
 PrintStream ps;
 private String userName;
 private String passWord;
 private String email;
 private String status;
 static Vector<PlayerHandler> players = new Vector<PlayerHandler>();
 Socket socket;
 PrintStream ps;  
    private String username;
    private String email;
    private String password;
    private String status;
    private int totalScore;
    private int numPlayedGames;
 static Vector<PlayerHandler> players = new Vector<PlayerHandler>();   
 
 public PlayerHandler(Socket cs)
{
     try {
         dis = new DataInputStream(cs.getInputStream());
         ps = new PrintStream(cs.getOutputStream());
        socket = cs;
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
        String completeMsg = dis.readLine();
        System.out.println(completeMsg);
        StringTokenizer tokenizer = new StringTokenizer(completeMsg,";");
        
        String header = tokenizer.nextToken();
        switch (header){
            case "request" :
                
                break;
            case "login":
               String nameL= tokenizer.nextToken();
               String pswL= tokenizer.nextToken();
               int result;
        try {
            result = DataAccessLayer.logIn(nameL, pswL);
             if (result==1)
                {
                    userName= nameL;
                    passWord= pswL;
                    players.add(this);
                    ps.println("1;" + userName);
                }
                else
                {
                    ps.println("0");
                    socket.close();
                }
        } catch (SQLException ex) {
            Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
               
                break;
            case "signup":
                String mail= tokenizer.nextToken();
                String nameS= tokenizer.nextToken();
               String pswS= tokenizer.nextToken();
               int resultS = 0;
        try {
            resultS = DataAccessLayer.signUp(mail, nameS, pswS);
             if (resultS==1)
                {
                    ps.println("1");
                    socket.close();
                    
                }
                else
                {
                    ps.println("0");
                    socket.close();
                }
               
        } catch (SQLException ex) {
            Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
               
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