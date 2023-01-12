/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineplayingtest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author ITi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label playerX;
    @FXML
    private Label playerO;
    @FXML
    private Button box1;
    @FXML
    private Button box9;
    @FXML
    private Button box8;
    @FXML
    private Button box7;
    @FXML
    private Button box6;
    @FXML
    private Button box5;
    @FXML
    private Button box4;
    @FXML
    private Button box3;
    @FXML
    private Button box2;
    @FXML
    private Button back_btn_board_sc;
    @FXML
    private MediaView videoPlayer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void notifyPressing(ActionEvent event) {
    }

    @FXML
    private void handleBackButtonAction(ActionEvent event) {
    }

    @FXML
    private void removeVideo(MouseEvent event) {
    }
    
}
