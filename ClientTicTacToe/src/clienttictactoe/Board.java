package clienttictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Board extends Pane {

    protected final Rectangle rectangle;
    protected final Rectangle rectangle0;
    protected final Rectangle rectangle1;
    protected final Rectangle rectangle2;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label playerX;
    protected final Label playerO;
    protected final Button box1;
    protected final Button box9;
    protected final Button box8;
    protected final Button box7;
    protected final Button box6;
    protected final Button box5;
    protected final Button box4;
    protected final Button box3;
    protected final Button box2;
    protected final Button playAgain;
    protected final Button boardBckBtn;
    private Stage stage;

    public Board(Stage stage) {

        this.stage=stage;
        rectangle = new Rectangle();
        rectangle0 = new Rectangle();
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        playerX = new Label();
        playerO = new Label();
        box1 = new Button();
        box9 = new Button();
        box8 = new Button();
        box7 = new Button();
        box6 = new Button();
        box5 = new Button();
        box4 = new Button();
        box3 = new Button();
        box2 = new Button();
        playAgain = new Button();
        boardBckBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(1080.0);
        setStyle("-fx-background-color: #1F3274;");

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setHeight(450.0);
        rectangle.setLayoutX(416.0);
        rectangle.setLayoutY(165.0);
        rectangle.setFill(Color.LIGHTGREY);
        rectangle.setStroke(javafx.scene.paint.Color.valueOf("#555b6907"));
        rectangle.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(16.0);

        rectangle0.setArcHeight(5.0);
        rectangle0.setArcWidth(5.0);
        rectangle0.setHeight(19.0);
        rectangle0.setLayoutX(281.0);
        rectangle0.setLayoutY(291.0);
        rectangle0.setFill(Color.LIGHTGREY);
        rectangle0.setStroke(javafx.scene.paint.Color.valueOf("#555b6900"));
        rectangle0.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle0.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle0.setWidth(450.0);

        rectangle1.setArcHeight(5.0);
        rectangle1.setArcWidth(5.0);
        rectangle1.setHeight(450.0);
        rectangle1.setLayoutX(585.0);
        rectangle1.setLayoutY(165.0);
        rectangle1.setFill(Color.GREY);
        rectangle1.setStroke(javafx.scene.paint.Color.valueOf("#555b6900"));
        rectangle1.setStrokeLineCap(javafx.scene.shape.StrokeLineCap.ROUND);
        rectangle1.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle1.setWidth(16.0);

        rectangle2.setArcHeight(5.0);
        rectangle2.setArcWidth(5.0);
        rectangle2.setHeight(19.0);
        rectangle2.setLayoutX(281.0);
        rectangle2.setLayoutY(453.0);
        rectangle2.setFill(Color.GREY);
        rectangle2.setStroke(javafx.scene.paint.Color.valueOf("#555b6900"));
        rectangle2.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle2.setWidth(450.0);

        label.setLayoutX(350.0);
        label.setLayoutY(23.0);
        label.setPrefHeight(65.0);
        label.setPrefWidth(99.0);
        label.setText("Tic");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4948"));
        label.setFont(new Font("Showcard Gothic", 50.0));

        label0.setLayoutX(567.0);
        label0.setLayoutY(23.0);
        label0.setPrefHeight(65.0);
        label0.setPrefWidth(99.0);
        label0.setText("Toe");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#ff4948"));
        label0.setFont(new Font("Showcard Gothic", 50.0));

        label1.setLayoutX(457.0);
        label1.setLayoutY(23.0);
        label1.setPrefHeight(65.0);
        label1.setPrefWidth(99.0);
        label1.setText("Tac");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#febd08"));
        label1.setFont(new Font("Showcard Gothic", 50.0));

        playerX.setLayoutX(35.0);
        playerX.setLayoutY(138.0);
        playerX.setPrefHeight(55.0);
        playerX.setPrefWidth(175.0);
        //playerX.setText("Player X");
        playerX.setTextFill(javafx.scene.paint.Color.valueOf("#febd08"));
        playerX.setFont(new Font("Bookman Old Style", 35.0));

        playerO.setLayoutX(898.0);
        playerO.setLayoutY(138.0);
        playerO.setPrefHeight(55.0);
        playerO.setPrefWidth(175.0);
        //playerO.setText("Player O");
        playerO.setTextFill(javafx.scene.paint.Color.valueOf("#ff4948"));
        playerO.setFont(new Font("Bookman Old Style", 35.0));

        box1.setLayoutX(284.0);
        box1.setLayoutY(165.0);
        box1.setMnemonicParsing(false);
        box1.setPrefHeight(122.0);
        box1.setPrefWidth(132.0);
        box1.setStyle("-fx-background-color: #1F3274;");
        box1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box1.setFont(new Font(33.0));

        box9.setLayoutX(601.0);
        box9.setLayoutY(472.0);
        box9.setMnemonicParsing(false);
        box9.setPrefHeight(140.0);
        box9.setPrefWidth(132.0);
        box9.setStyle("-fx-background-color: #1F3274;");
        box9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box9.setFont(new Font(33.0));

        box8.setLayoutX(434.0);
        box8.setLayoutY(474.0);
        box8.setMnemonicParsing(false);
        box8.setPrefHeight(140.0);
        box8.setPrefWidth(150.0);
        box8.setStyle("-fx-background-color: #1F3274;");
        box8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box8.setFont(new Font(33.0));

        box7.setLayoutX(281.0);
        box7.setLayoutY(474.0);
        box7.setMnemonicParsing(false);
        box7.setPrefHeight(140.0);
        box7.setPrefWidth(132.0);
        box7.setStyle("-fx-background-color: #1F3274;");
        box7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box7.setFont(new Font(33.0));

        box6.setLayoutX(607.0);
        box6.setLayoutY(310.0);
        box6.setMnemonicParsing(false);
        box6.setPrefHeight(115.0);
        box6.setPrefWidth(150.0);
        box6.setStyle("-fx-background-color: #1F3274;");
        box6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box6.setFont(new Font(33.0));

        box5.setLayoutX(432.0);
        box5.setLayoutY(310.0);
        box5.setMnemonicParsing(false);
        box5.setPrefHeight(140.0);
        box5.setPrefWidth(150.0);
        box5.setStyle("-fx-background-color: #1F3274;");
        box5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box5.setFont(new Font(33.0));

        box4.setLayoutX(281.0);
        box4.setLayoutY(310.0);
        box4.setMnemonicParsing(false);
        box4.setPrefHeight(140.0);
        box4.setPrefWidth(132.0);
        box4.setStyle("-fx-background-color: #1F3274;");
        box4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box4.setFont(new Font(33.0));

        box3.setLayoutX(607.0);
        box3.setLayoutY(165.0);
        box3.setMnemonicParsing(false);
        box3.setPrefHeight(122.0);
        box3.setPrefWidth(124.0);
        box3.setStyle("-fx-background-color: #1F3274;");
        box3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box3.setFont(new Font(33.0));

        box2.setLayoutX(434.0);
        box2.setLayoutY(165.0);
        box2.setMnemonicParsing(false);
        box2.setPrefHeight(122.0);
        box2.setPrefWidth(150.0);
        box2.setStyle("-fx-background-color: #1F3274;");
        box2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        box2.setFont(new Font(33.0));

        playAgain.setLayoutX(913.0);
        playAgain.setLayoutY(644.0);
        playAgain.setMnemonicParsing(false);
        playAgain.setPrefHeight(55.0);
        playAgain.setPrefWidth(144.0);
        playAgain.setStyle("-fx-background-color: #febd08;");
        playAgain.setText("Play Again");
        playAgain.setTextFill(javafx.scene.paint.Color.valueOf("#282727"));
        playAgain.setFont(new Font("System Bold", 20.0));

        boardBckBtn.setLayoutX(35.0);
        boardBckBtn.setLayoutY(23.0);
        boardBckBtn.setMnemonicParsing(false);
        boardBckBtn.setPrefHeight(55.0);
        boardBckBtn.setPrefWidth(79.0);
        boardBckBtn.setStyle("-fx-background-color: #ff4948; -fx-border-radius: 30px;");
        boardBckBtn.setText("<");
        boardBckBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        boardBckBtn.setFont(new Font(36.0));

        getChildren().add(rectangle);
        getChildren().add(rectangle0);
        getChildren().add(rectangle1);
        getChildren().add(rectangle2);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(playerX);
        getChildren().add(playerO);
        getChildren().add(box1);
        getChildren().add(box9);
        getChildren().add(box8);
        getChildren().add(box7);
        getChildren().add(box6);
        getChildren().add(box5);
        getChildren().add(box4);
        getChildren().add(box3);
        getChildren().add(box2);
        getChildren().add(playAgain);
        getChildren().add(boardBckBtn);

    }
}
