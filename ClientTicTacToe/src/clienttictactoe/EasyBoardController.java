/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author ميناناجحعبدالمسيحزكى
 */
public class EasyBoardController implements Initializable {

    @FXML
    private Button box1;
    @FXML
    private Button box11;
    @FXML
    private Button box111;
    @FXML
    private Button box1111;
    @FXML
    private Button box11111;
    @FXML
    private Button box111111;
    @FXML
    private Button box1111111;
    @FXML
    private Button box11111111;
    @FXML
    private Button box111111111;

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
    
}
