/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertictactoe;

/**
 *
 * @author ميناناجحعبدالمسيحزكى
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ميناناجحعبدالمسيحزكى
 */
public class ServerSide {
    
    ServerSocket serverSocket;
    Thread thread;

    public ServerSide() throws IOException {

        serverSocket = new ServerSocket(9050);

        thread = new Thread(()->{

            while(true){

                thread = new Thread(() -> {
                    while(true){
                        try {
                            Socket clientSocket = serverSocket.accept();
                            new PlayerHandler(clientSocket);
                            
                        }
                        catch (IOException ex) {
                            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                thread.start();  
       }
            });
    }

    public static void main(String [] args){

    }
}
            

   
