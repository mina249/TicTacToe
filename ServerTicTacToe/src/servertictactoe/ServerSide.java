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
package servertictactoe;

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

    public ServerSide() {
        try {
            serverSocket = new ServerSocket(5009);
            while(true){
                Socket clientSocket = serverSocket.accept();
                new PlayerHandler(clientSocket);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerSide.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}