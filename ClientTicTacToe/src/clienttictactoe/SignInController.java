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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ميناناجحعبدالمسيحزكى
 */
public class SignInController implements Initializable {

    @FXML
    private Button btn_Back;
    @FXML
    private TextField tf_UserName;
    @FXML
    private TextField tf_Password;
    @FXML
    private Button btn_SiginIn;
    @FXML
    private Button btn_SiginUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void handleSignupButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void handleBackButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("HomePageScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSignInButtonAction(ActionEvent event) {
        try {
             Socket mysocket;
            DataInputStream ear;
            PrintStream mouth;
            String msg;
            String reply;
            mysocket= new Socket("127.0.0.1",2611);
            mouth= new PrintStream(mysocket.getOutputStream());
            msg= "login" + ";" + tf_UserName.getText() + ";" + tf_Password.getText();
            mouth.println(msg);
            ear= new DataInputStream(mysocket.getInputStream());
            reply= ear.readLine();
            if(reply.equals("0"))
            {
                tf_UserName.setText("User name or password is incorrect");
                tf_UserName.setStyle("-fx-text-fill red");
            }else {
                Parent root = FXMLLoader.load(getClass().getResource("OnlinePlayerList.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
