/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttictactoe;

import java.io.IOException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nada
 */
public class BoardScrController implements Initializable {

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
    private Button playAgain;
    @FXML
    private Button back_btn_board_sc;
    private String textOfBtn = "X";
    private Button targetedBtn;
    private boolean someoneIsWin = false;
    private boolean firstPllayerWin = false ;
    private boolean secondPlayerWin = false;
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;
    private String winnerName;
    private String gameStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        highlightTheLabel('o');
    }    
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) {
        gameStatus = "terminated";
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HomePageScreen.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomePageScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void notifyPressing(ActionEvent event) {
        handleThePressedBtnTwoPlayersMood(event);
    }
    @FXML
    private void handlePlayAgainBtn(ActionEvent event) {
        setStandrdStart();
    }
    public void handleThePressedBtnTwoPlayersMood(ActionEvent e){
        if(!someoneIsWin){
            targetedBtn = (Button) e.getSource();
            if(targetedBtn.getText().equals("")){               
                if(textOfBtn=="X"){
                    targetedBtn.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #1F3274; ");
                    textOfBtn="O";
                    highlightTheLabel('x');
                }
                else{
                    targetedBtn.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
                    textOfBtn="X";
                    highlightTheLabel('o');
                }  
                targetedBtn.setText(textOfBtn); 
                revieweTheBoaed();
            }
        }
    }
    
    private boolean isAnyRowNotifyWinningSomeone(){
        boolean flag = false;
        if(box1.getText().equals(box2.getText()) && box2.getText().equals(box3.getText()) && !box1.getText().equals("")){
            highlightThusBtns(box1, box2,box3);
            if(box1.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } else if(box4.getText().equals(box5.getText()) && box5.getText().equals(box6.getText()) && !box4.getText().equals("")){
            highlightThusBtns(box4, box5,box6);
            if(box4.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } else if(box7.getText().equals(box8.getText()) && box8.getText().equals(box9.getText()) && !box7.getText().equals("")){
            highlightThusBtns(box7, box8,box9);
            if(box7.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } 
        return flag;
    }
    private boolean isAnyColumnNotifyWinningSomeone(){
    boolean flag = false;
        if(box1.getText().equals(box4.getText()) && box4.getText().equals(box7.getText()) && !box1.getText().equals("")){
            highlightThusBtns(box1, box4,box7);
            if(box1.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } else if(box2.getText().equals(box5.getText()) && box5.getText().equals(box8.getText()) && !box2.getText().equals("")){
            highlightThusBtns(box2, box5,box8);
            if(box2.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } else if(box3.getText().equals(box6.getText()) && box6.getText().equals(box9.getText()) && !box3.getText().equals("")){
            highlightThusBtns(box3, box6,box9);
            if(box3.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } 
        return flag;
    }
    private boolean isAnyDiagonalNotifyWinningSomeone()
    {
    boolean flag = false;
        if(box1.getText().equals(box5.getText()) && box5.getText().equals(box9.getText()) && !box1.getText().equals("")){
            highlightThusBtns(box1, box5,box9);
            if(box1.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } else if(box3.getText().equals(box5.getText()) && box5.getText().equals(box7.getText()) && !box3.getText().equals("")){
            highlightThusBtns(box3, box5,box7);
            if(box3.getText().equals("X")){
                firstPllayerWin = true;
            }else{
                secondPlayerWin = true;
            }
            flag = true;
        } 
        return flag;
    }
    private boolean isBoardFull(){
         boolean flag = false;
         if(!box1.getText().equals("") && !box2.getText().equals("") && !box3.getText().equals("") && !box4.getText().equals("")
                    && !box5.getText().equals("") && !box6.getText().equals("")&& !box7.getText().equals("")
                    && !box8.getText().equals("") && !box9.getText().equals("")){
                    flag = true;
        }
        return flag;
    }
    private void revieweTheBoaed (){
        if (isAnyRowNotifyWinningSomeone()){
            someoneIsWin = true;
        }else if (isAnyColumnNotifyWinningSomeone()){
            someoneIsWin = true;
        }else if (isAnyDiagonalNotifyWinningSomeone()){
            someoneIsWin = true;
        }
        if (someoneIsWin){
                handleWinningSomeOne();
        }else if (isBoardFull()){
            System.out.println("no one win..!");
            // TODO :- HANDLE NO ONE WIN
            handleNoOneWin();
        }   
    } 
    private void highlightThusBtns(Button b1, Button b2,Button b3){
        if(b1.getText().equals("X")){
        b1.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; ");
        b2.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; ");
        b3.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; ");
        }else{
        b1.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");    
        b2.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");
        b3.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");
        }
    }
    public void handleWinningSomeOne(){
            if(firstPllayerWin){
                firstPlayerScore += 10;
                highlightTheLabel('x');

            }else if(secondPlayerWin){
                secondPlayerScore += 10;
                highlightTheLabel('o'); 
            }
            gameStatus = "finished";
    } 
    public void handleNoOneWin(){
        playerX.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
        playerO.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert a = new Alert(Alert.AlertType.NONE); 
        a.setTitle("NO ONE WIN ..!");
        a.setContentText("the game finished without winning any one");
        a.getDialogPane().getButtonTypes().add(ok);
        a.showAndWait();
        setStandrdStart();
    }
    private void highlightTheLabel(char ch){
         if (ch == 'x' || ch == 'X' ){
            playerO.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #1F3274; ");
            playerX.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; "); 
         }else if(ch == 'o' || ch == 'O' ){
            playerX.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
            playerO.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");
         } 
    }
    private void setStandrdStart(){
        textOfBtn = "X";
        someoneIsWin = false;
        firstPllayerWin = false ;
        secondPlayerWin = false; 
        box1.setText("");box1.setStyle("-fx-background-color: #1F3274; ");
        box2.setText("");box2.setStyle("-fx-background-color: #1F3274; ");
        box3.setText("");box3.setStyle("-fx-background-color: #1F3274; ");
        box4.setText("");box4.setStyle("-fx-background-color: #1F3274; ");
        box5.setText("");box5.setStyle("-fx-background-color: #1F3274; ");
        box6.setText("");box6.setStyle("-fx-background-color: #1F3274; ");
        box7.setText("");box7.setStyle("-fx-background-color: #1F3274; ");
        box8.setText("");box8.setStyle("-fx-background-color: #1F3274; ");
        box9.setText("");box9.setStyle("-fx-background-color: #1F3274; ");
        someoneIsWin = false;
         highlightTheLabel('o');
    }
    
} 