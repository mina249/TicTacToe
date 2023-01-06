package clienttictactoe;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
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
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class BoardScrController implements Initializable {

    @FXML
    private Label playerX;
    @FXML
    private Label playerO;
    @FXML
    private Label title;
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
    @FXML
    private MediaView videoPlayer;
    private Media media;
    private MediaPlayer mediaPlayer;
    private File mediaFile;
    private String textOfBtn = "X";
    private Button targetedBtn;
    private static int firstPlayerScore = 0;
    private static int secondPlayerScore = 0;
    private int numberOfClickedBoxes = 0;
    private String winnerName;
    private Button []board = {box1,box2,box3,box4,box5,box6,box7,box8,box9};
    private String ai = "X";
    private String user = "O";
    private String gameType;
    private boolean justStarted = true;
    

    private enum GameStatus {
        TERMINATED, PLAYING, WINFIRSTPLAYER, WINSECONDPLAYER, DRAW;
    }

    private enum GameType {
        EASY, MEDIUM, HARD, TWOPLAYERSLOCAL, MULTIPLAYER;
    }

    GameStatus currentStatus;
    GameType currentGameType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentStatus = GameStatus.PLAYING;
        highlightTheLabel('o');
        
    }

    @FXML
    private void notifyPressing(ActionEvent event) {
        // Sets difficulty or game type after first button press
        if(justStarted == true)
        {    
        gameType = title.getText();
        switch (gameType) {
            case "EASY DIFFICULTY":
                currentGameType = GameType.EASY;
                break;
            case "MEDIUM DIFFICULTY":
                currentGameType = GameType.MEDIUM;
                break;
            case "HARD DIFFICULTY":
                currentGameType = GameType.HARD;
                break;
            case "TWOPLAYERS":
                currentGameType = GameType.TWOPLAYERSLOCAL;
                break;
            case "MULTIPLAYER":
                currentGameType = GameType.MULTIPLAYER;
                break;
            default:
                break;
        }
        justStarted = false;
        }
      
        
        switch (currentGameType) {
            case EASY:
                easyMode();
                break;
            case MEDIUM:
                break;
            case HARD:
                
                break;
            case TWOPLAYERSLOCAL:
                handleThePressedBtnTwoPlayersMood(event);
                break;
            case MULTIPLAYER:
                break;
            default:
                break;
        }
        System.out.println(currentStatus);
    }

    @FXML
    private void handlePlayAgainBtn(ActionEvent event) {
        setStandrdStart();
    }
    
    @FXML
    private void handleBackButtonAction(ActionEvent event) throws IOException {
        currentStatus = GameStatus.TERMINATED;
        Parent root = FXMLLoader.load(getClass().getResource("HomePageScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void handleThePressedBtnTwoPlayersMood(ActionEvent e) {
        if (currentStatus == GameStatus.PLAYING) {
            targetedBtn = (Button) e.getSource();
            if (targetedBtn.getText().equals("")) {
                if (textOfBtn == "X") {
                    targetedBtn.setStyle("-fx-text-fill: #ff4948;-fx-background-color: #1F3274; ");
                    textOfBtn = "O";
                    highlightTheLabel('x');
                } else {
                    targetedBtn.setStyle("-fx-text-fill: #febd08;-fx-background-color: #1F3274; ");
                    textOfBtn = "X";
                    highlightTheLabel('o');
                }
                targetedBtn.setText(textOfBtn);
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
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box4.getText().equals(box5.getText()) && box5.getText().equals(box6.getText())
                && !box4.getText().equals("")) {
            highlightThusBtns(box4, box5, box6);
            if (box4.getText().equals("X")) {
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box7.getText().equals(box8.getText()) && box8.getText().equals(box9.getText())
                && !box7.getText().equals("")) {
            highlightThusBtns(box7, box8, box9);
            if (box7.getText().equals("X")) {
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
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
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box2.getText().equals(box5.getText()) && box5.getText().equals(box8.getText())
                && !box2.getText().equals("")) {
            highlightThusBtns(box2, box5, box8);
            if (box2.getText().equals("X")) {
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box3.getText().equals(box6.getText()) && box6.getText().equals(box9.getText())
                && !box3.getText().equals("")) {
            highlightThusBtns(box3, box6, box9);
            if (box3.getText().equals("X")) {
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
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
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
            }
            flag = true;
        } else if (box3.getText().equals(box5.getText()) && box5.getText().equals(box7.getText())
                && !box3.getText().equals("")) {
            highlightThusBtns(box3, box5, box7);
            if (box3.getText().equals("X")) {
                currentStatus = GameStatus.WINFIRSTPLAYER;
            } else {
                currentStatus = GameStatus.WINSECONDPLAYER;
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

    public void handleWinningSomeOne(){
        if (currentStatus == GameStatus.WINFIRSTPLAYER) {
            firstPlayerScore += 10;
            highlightTheLabel('x');
        } else if (currentStatus == GameStatus.WINSECONDPLAYER) {
            secondPlayerScore += 10;
            highlightTheLabel('o');
        }
        playVideo();
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
        currentStatus = GameStatus.PLAYING;
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
        textOfBtn = "X";
        numberOfClickedBoxes = 0;
        highlightTheLabel('o');
        removeVideo();
    }

    
    
    
    
    
   
    public boolean notifiyWining(){
        
        if(isAnyColumnNotifyWinningSomeone()==true || isAnyDiagonalNotifyWinningSomeone()==true || isAnyRowNotifyWinningSomeone()==true)
            return true;
        
        return false;
    }
    public int evaluateBoard(Button[]board){
    
        if(isAnyColumnNotifyWinningSomeone()==true){
            
            if(board[0].getText().equals(ai) || board[1].getText().equals(ai)|| board[2].getText().equals(ai)){
                return 10;
            }else if (board[0].getText().equals(user) || board[1].getText().equals(user)|| board[2].getText().equals(user)){
                return -10;
            }
        }
        if(isAnyRowNotifyWinningSomeone()==true){
            if(board[0].getText().equals(ai) ||board[3].getText().equals(ai)|| board[6].getText().equals(ai)){
                return 10;
            }else if(board[0].getText().equals(user) ||board[3].getText().equals(user)|| board[6].getText().equals(user)){
                return -10;
            }
        }
        if(isAnyDiagonalNotifyWinningSomeone()==true){
            if(board[0].getText().equals(ai) || board[2].getText().equals(ai)){
                return 10;
            }else if(board[0].getText().equals(user) || board[2].getText().equals(user)){
                return -10;
            }
        }
        return 0;
    }
    
    
    public int minMax(Button[]board , int depth , boolean isAi){
    
        int score = evaluateBoard(board);
        if(score == 10 || score == -10 || score == 0){
            return score;
        }
        else if(isBoardFull()==true){
            return 0;
        }
        
        if(isAi){
            int bestScore = Integer.MIN_VALUE;
            for(int i =0 ; i <9 ;i++){
                if(board[i].getText().equals("")){
                   board[i].setText(ai);
                   bestScore = Math.max(bestScore, minMax(board, depth+1,false));
                   board[i].setText("");
                
                }
            
            
            }
        return bestScore - depth;
        }else{
            int bestScore = Integer.MAX_VALUE;
             for(int i =0 ; i <9 ;i++){
                if(board[i].getText().equals("")){
                   board[i].setText(user);
                   bestScore = Math.max(bestScore, minMax(board, depth+1,true));
                   board[i].setText("");
                
                }
            }
        return bestScore + depth;
        
        }
    }
    public Button findBestPlay(Button [] Board){
        Button bestButton = new Button();
        int bestScore = Integer.MIN_VALUE;
        for(int i = 0 ; i<9 ; i++){
            if(board[i].getText().equals("")){
                board[i].setText(ai);
                
                int score = minMax(board , 0 , false);
                board[i].setText("");
                if(score>bestScore){
                    bestButton = board[i];
                    bestScore = score;
                }
            }     
        }
        return bestButton;
    } 
    
    
    public Button easyMode(){
    int index;
    Random random = new Random();
    Button randomButton = new Button();
    while(true){
        index = random.nextInt(9);
        if(board[index].getText().equals("")){
            randomButton = board[index];
            break;
        }
    }
    return randomButton;
    }
    public Button mediumMode(){
        if(board[0].getText().equals(board[1].getText()) && board[0].getText().equals(user)){
            return board[2];
        }else if(board[0].getText().equals(board[3].getText()) && board[0].getText().equals(user)){
            return board[6];
        }else if(board[3].getText().equals(board[4].getText()) && board[3].getText().equals(user)){
            return board[5];
        }else if(board[6].getText().equals(board[7].getText()) && board[7].getText().equals(user)){
            return board[8];
        }else if(board[1].getText().equals(board[4].getText()) && board[1].getText().equals(user)){
            return board[7];
        }else if(board[2].getText().equals(board[5].getText()) && board[2].getText().equals(user)){
            return board[8];
        }else if(board[0].getText().equals(board[4].getText()) && board[0].getText().equals(user)){
            return board[8];
        }else if(board[2].getText().equals(board[4].getText()) && board[2].getText().equals(user)){
            return board[6];
        }else{
            Random random = new Random();
            int index;
            while(true){
                 index = random.nextInt(9);
                if(board[index].getText().equals("")){
                    break;
                }
                
            }
            return board[index];
        }
        
    
    }
    public Button hardMode(){
        return findBestPlay(board);
    }
    

     public void intializeLabels(String titles, String playerxName, String playeroName)
     {
        title.setText(titles);
        if(titles.contains("DIFFICULTY"))
        {
            playerX.setText("Player X\n" + "You");
            playerO.setText("Player O\n" + "Computer");
        }
        else if(titles.equals("TWOPLAYERS"))
        {
            playerX.setText("Player X\n" + playerxName);
            playerO.setText("Player O\n" + playeroName);
        }
        else if(titles.equals("MULTIPLAYER"))
        {
        }
        
        playerX.setTextFill(javafx.scene.paint.Color.valueOf("#ff4948"));
        playerO.setTextFill(javafx.scene.paint.Color.valueOf("#ff4948"));
        playerX.setFont(new Font("Bookman Old Style", 35.0));
        playerO.setFont(new Font("Bookman Old Style", 35.0));
     } 
     public void playVideo()
     {
        if(currentStatus == GameStatus.WINFIRSTPLAYER)
        {
            mediaFile = new File("src/clienttictactoe/Fireworks.mp4");
        }
        else
        {
            mediaFile = new File("src/clienttictactoe/Fireworks.mp4");
        }
        try {
            media = new Media(mediaFile.toURI().toURL().toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(BoardScrController.class.getName()).log(Level.SEVERE, null, ex);
        }
        mediaPlayer = new MediaPlayer(media);
        videoPlayer.setMediaPlayer(mediaPlayer);
        //mediaPlayer.setMute(true);
        videoPlayer.setVisible(true);
        videoPlayer.setFitHeight(600);
        videoPlayer.setFitWidth(1080);
        mediaPlayer.play();
     }
     
     public void removeVideo()
     {
        // On mouse click
        mediaPlayer.stop();
        videoPlayer.setVisible(false);
     }
}