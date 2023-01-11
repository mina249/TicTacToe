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
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ميناناجحعبدالمسيحزكى
 */
public class SignUpController implements Initializable {

    @FXML
    private Button btn_Back;
    @FXML
    private TextField tf_UserNmae;
    @FXML
    private TextField tf_Email;
    @FXML
    private TextField tf_Password;
    @FXML
    private Button btn_SiginUp;
    Thread th;
    Socket mysocket;
                DataInputStream ear;
                PrintStream mouth;
                String msg;
                String reply;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mysocket= new Socket("127.0.0.1",5009);
            mouth= new PrintStream(mysocket.getOutputStream());
            ear= new DataInputStream(mysocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    @FXML
    public void handleSignupButtonAction(ActionEvent event) throws Exception{
       th = new Thread(()-> {
           try {
                msg= "signup" + ";" + tf_UserNmae.getText() + ";" +  tf_Email.getText() + ";" + tf_Password.getText();
               
                mouth.println(msg);
                
                reply= ear.readLine();
                /*if(reply.equals("0"))
                {
                    tf_UserNmae.setText("User name already exists, please write a new one");
                    tf_UserNmae.setStyle("-fx-text-fill red");
                }else {*/
                    Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }  catch (IOException ex) {
                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
    });
       th.start();
    }
    @FXML
     public void handlBackButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
   
}
