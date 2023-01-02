/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttictactoe.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AHM
 */
public class OnlinePlayerListController implements Initializable {

    @FXML
    private Button buttonBack;
    @FXML
    private Button buttonRecord;
    @FXML
    private Label labelLocalPlayerName;
    @FXML
    private Label labelLocalPlayerName1;
    @FXML
    private Label labelLocalPlayerName2;
    @FXML
    private Label labelLocalPlayerName3;
    @FXML
    private Label labelLocalPlayerName4;
    @FXML
    private Label labelLocalPlayerName5;
    @FXML
    private Label labelLocalPlayerName6;
    @FXML
    private Label labelLocalPlayerName7;
    @FXML
    private Button buttonChallenge;
    @FXML
    private Button buttonChallenge1;
    @FXML
    private Button buttonChallenge2;
    @FXML
    private Button buttonChallenge3;
    @FXML
    private Button buttonChallenge4;
    @FXML
    private Button buttonChallenge5;
    @FXML
    private Button buttonChallenge6;
    @FXML
    private Button buttonChallenge7;

    public void handleLogoutButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
        stage.show();
    }
    
        public void handleChallengeButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Board scr.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
        stage.show();   
 
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
