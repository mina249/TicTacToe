/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttictactoe;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ميناناجحعبدالمسيحزكى
 */
public class ClientSide {
    DataInputStream dis;
    PrintStream ps;
    static Socket socket;
    
    public ClientSide(){
        try {
            socket = new Socket("127.1.1.0",5009);
            dis = new DataInputStream(socket.getInputStream ());
            ps = new PrintStream(socket.getOutputStream ());
        } catch (IOException ex) {
            Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}