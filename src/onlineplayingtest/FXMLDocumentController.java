/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineplayingtest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaView;

/**
 *
 * @author ITi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private MediaView videoPlayer;

    @FXML
    private void handlePlayAgainBtn(ActionEvent event) {
    }

    @FXML
    private void handleBackButtonAction(ActionEvent event) {
    }

    @FXML
    private void removeVideo(MouseEvent event) {
    }
     private enum GameStatus {
        TERMINATED, PLAYING, WINFIRSTPLAYER, WINSECONDPLAYER, DRAW;
    }

    private enum GameType {
        EASY, MEDIUM, HARD, TWOPLAYERSLOCAL, MULTIPLAYER;
    }
    private Label label;
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
    private Button playAgain;
    @FXML
    private Button back_btn_board_sc;
    
    private Button targetedBtn;
    private Character targetedBtnIndex ;
    private Boolean myTurn = true;
    private Character textOfBtn = 'X';
    private int numberOfClickedBoxes = 0;
    private int firstPlayerScore;
    private int secondPlayerScore;
    private Socket mySocket ;
    private PrintStream ps ;
    private DataInputStream dis ;
    private String receivedMsg;
    private String sendedMsg;
    private Thread updateUIThread; 
    GameStatus currentstatus ;
    GameType currentGameType;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
             currentstatus = GameStatus.PLAYING;
             mySocket = new Socket("127.0.0.1", 5005);
             ps = new PrintStream(mySocket.getOutputStream());
             dis = new DataInputStream(mySocket.getInputStream());
            } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
       receivedMsg = "";
       
       updateUIThread = new Thread(){
            @Override
            public void run(){
                while (true){
                  
                    try {
                        receivedMsg = dis.readLine() + "\n";
                        targetedBtnIndex = receivedMsg.charAt(0);
                        textOfBtn =  receivedMsg.charAt(1);
                        System.out.println("the data reched"+receivedMsg);
                        Platform.runLater(new Runnable(){
                            @Override
                            public void run() {
                                setTxtToAcertainButton(targetedBtnIndex,textOfBtn);
                                
                            }
                        
                        
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        updateUIThread.start();
    }    

    @FXML
    private void notifyPressing(ActionEvent event) {
        handleThePressedBtnOnlineMood(event);
    }


    
    public void handleThePressedBtnOnlineMood(ActionEvent e){
        targetedBtn = (Button) e.getSource();
        targetedBtnIndex = targetedBtn.getId().charAt(3);
        if(currentstatus == GameStatus.PLAYING && myTurn){
            textOfBtn = 'X';
            myTurn = false;
        }else{
            textOfBtn = 'O';
            myTurn = true;
        }
        sendedMsg = ""+targetedBtnIndex+textOfBtn;
        ps.println(sendedMsg);

    }
     public void setTxtToAcertainButton(char indexOfBtn,char textOfBtn){
        if(textOfBtn == 'X'){
            targetedBtn.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #1F3274; ");
            highlightTheLabel('x');
        }else{
            targetedBtn.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
            highlightTheLabel('o'); 
        }
        switch(targetedBtnIndex){
                            case '1':box1.setText(""+textOfBtn);
                                     break;
                            case '2':box2.setText(""+textOfBtn);
                                     break;
                            case '3':box3.setText(""+textOfBtn);
                                     break;
                            case '4':box4.setText(""+textOfBtn);
                                     break;
                            case '5':box5.setText(""+textOfBtn);
                                     break;
                            case '6':box6.setText(""+textOfBtn);
                                     break;
                            case '7':box7.setText(""+textOfBtn);
                                     break;
                            case '8':box8.setText(""+textOfBtn);
                                     break;
                            case '9':box9.setText(""+textOfBtn);
                                     break;
                            default :System.out.println(textOfBtn);
                                
                        }
        numberOfClickedBoxes++;
        reviewTheBoard();
    }

    
    public void handleThePressedBtnTwoPlayersMood(ActionEvent e) {
        if (currentstatus == GameStatus.PLAYING) {
            targetedBtn = (Button) e.getSource();
            if (targetedBtn.getText().equals("")) {
                if (textOfBtn == 'X') {
                    targetedBtn.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #1F3274; ");
                    textOfBtn = 'O';
                    highlightTheLabel('x');
                } else {
                    targetedBtn.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
                    textOfBtn = 'X';
                    highlightTheLabel('o');
                }
                targetedBtn.setText(""+textOfBtn);
                numberOfClickedBoxes++;
                reviewTheBoard();
            }
        }
    }
    
    private boolean isAnyRowNotifyWinningSomeone() {
        boolean flag = false;
        if (box1.getText().equals(box2.getText()) && box2.getText().equals(box3.getText())
                && !box1.getText().equals("")) {
            highlightThusBtns(box1, box2, box3);
            if (box1.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box4.getText().equals(box5.getText()) && box5.getText().equals(box6.getText())
                && !box4.getText().equals("")) {
            highlightThusBtns(box4, box5, box6);
            if (box4.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box7.getText().equals(box8.getText()) && box8.getText().equals(box9.getText())
                && !box7.getText().equals("")) {
            highlightThusBtns(box7, box8, box9);
            if (box7.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        }
        return flag;
    }

    private boolean isAnyColumnNotifyWinningSomeone() {
        boolean flag = false;
        if (box1.getText().equals(box4.getText()) && box4.getText().equals(box7.getText())
                && !box1.getText().equals("")) {
            highlightThusBtns(box1, box4, box7);
            if (box1.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box2.getText().equals(box5.getText()) && box5.getText().equals(box8.getText())
                && !box2.getText().equals("")) {
            highlightThusBtns(box2, box5, box8);
            if (box2.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box3.getText().equals(box6.getText()) && box6.getText().equals(box9.getText())
                && !box3.getText().equals("")) {
            highlightThusBtns(box3, box6, box9);
            if (box3.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        }
        return flag;
    }

    private boolean isAnyDiagonalNotifyWinningSomeone() {
        boolean flag = false;
        if (box1.getText().equals(box5.getText()) && box5.getText().equals(box9.getText())
                && !box1.getText().equals("")) {
            highlightThusBtns(box1, box5, box9);
            if (box1.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box3.getText().equals(box5.getText()) && box5.getText().equals(box7.getText())
                && !box3.getText().equals("")) {
            highlightThusBtns(box3, box5, box7);
            if (box3.getText().equals("X")) {
                currentstatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentstatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        }
        return flag;
    }

    private boolean isBoardFull() {
        boolean flag = false;
        if (numberOfClickedBoxes >= 9){
                flag = true;
            }
        return flag;
    }

    private void reviewTheBoard() {
        if (isAnyRowNotifyWinningSomeone() | isAnyColumnNotifyWinningSomeone()
                | isAnyDiagonalNotifyWinningSomeone()) {
            handleWinningSomeOne();
        } else if (isBoardFull()) {
            handleNoOneWin();
        }
    }

    private void highlightThusBtns(Button b1, Button b2, Button b3) {
        if (b1.getText().equals("X")) {
            b1.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; ");
            b2.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; ");
            b3.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; ");
        } else {
            b1.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");
            b2.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");
            b3.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");
        }
    }

    public void handleWinningSomeOne() {
        if (currentstatus == GameStatus.WINFIRSTPLAYER) {
            firstPlayerScore += 10;
            highlightTheLabel('x');
        } else if (currentstatus == GameStatus.WINSECONDPLAYER) {
            secondPlayerScore += 10;
            highlightTheLabel('o');
        }
    }

    public void handleNoOneWin() {
        playerX.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
        playerO.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setTitle("DRAW..!");
        a.setContentText("The game finished without anyone winning");
        a.getDialogPane().getButtonTypes().add(ok);
        a.showAndWait();
        setStandrdStart();
    }

    private void highlightTheLabel(char ch) {
        if (ch == 'x' || ch == 'X') {
            playerO.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #1F3274; ");
            playerX.setStyle("-fx-text-fill: #febd08;-fx-background-color: #999b99; ");
        } else if (ch == 'o' || ch == 'O') {
            playerX.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
            playerO.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #999b99; ");
        }
    }

    private void setStandrdStart() {
        currentstatus = GameStatus.PLAYING;
        box1.setText("");
        box1.setStyle("-fx-background-color: #1F3274; ");
        box2.setText("");
        box2.setStyle("-fx-background-color: #1F3274; ");
        box3.setText("");
        box3.setStyle("-fx-background-color: #1F3274; ");
        box4.setText("");
        box4.setStyle("-fx-background-color: #1F3274; ");
        box5.setText("");
        box5.setStyle("-fx-background-color: #1F3274; ");
        box6.setText("");
        box6.setStyle("-fx-background-color: #1F3274; ");
        box7.setText("");
        box7.setStyle("-fx-background-color: #1F3274; ");
        box8.setText("");
        box8.setStyle("-fx-background-color: #1F3274; ");
        box9.setText("");
        box9.setStyle("-fx-background-color: #1F3274; ");
        textOfBtn = 'X';
        numberOfClickedBoxes = 0;
        highlightTheLabel('o');
    }

    public boolean notifiyWining(){
        
        if(isAnyColumnNotifyWinningSomeone()==true || isAnyDiagonalNotifyWinningSomeone()==true || isAnyRowNotifyWinningSomeone()==true)
            return true;
        
        return false;
    }
}