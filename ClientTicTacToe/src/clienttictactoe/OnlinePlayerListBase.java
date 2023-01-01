package clienttictactoe;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public abstract class OnlinePlayerListBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints1;
    protected final Button buttonBack;
    protected final Button buttonRecord;
    protected final Label label;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints2;
    protected final FlowPane flowPane;
    protected final Label labelLocalPlayerName;
    protected final Label labelLocalPlayerName1;
    protected final Label labelLocalPlayerName2;
    protected final Label labelLocalPlayerName3;
    protected final Label labelLocalPlayerName4;
    protected final Label labelLocalPlayerName5;
    protected final Label labelLocalPlayerName6;
    protected final Label labelLocalPlayerName7;
    protected final FlowPane flowPane0;
    protected final Button buttonChallenge;
    protected final Button buttonChallenge1;
    protected final Button buttonChallenge2;
    protected final Button buttonChallenge3;
    protected final Button buttonChallenge4;
    protected final Button buttonChallenge5;
    protected final Button buttonChallenge6;
    protected final Button buttonChallenge7;

    public OnlinePlayerListBase() {

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        gridPane = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints1 = new RowConstraints();
        buttonBack = new Button();
        buttonRecord = new Button();
        label = new Label();
        gridPane0 = new GridPane();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        flowPane = new FlowPane();
        labelLocalPlayerName = new Label();
        labelLocalPlayerName1 = new Label();
        labelLocalPlayerName2 = new Label();
        labelLocalPlayerName3 = new Label();
        labelLocalPlayerName4 = new Label();
        labelLocalPlayerName5 = new Label();
        labelLocalPlayerName6 = new Label();
        labelLocalPlayerName7 = new Label();
        flowPane0 = new FlowPane();
        buttonChallenge = new Button();
        buttonChallenge1 = new Button();
        buttonChallenge2 = new Button();
        buttonChallenge3 = new Button();
        buttonChallenge4 = new Button();
        buttonChallenge5 = new Button();
        buttonChallenge6 = new Button();
        buttonChallenge7 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(720.0);
        setPrefWidth(1080.0);
        setStyle("-fx-background-color: #1F3274;");

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPercentHeight(15.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(15.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(0.0);
        columnConstraints1.setPercentWidth(70.0);
        columnConstraints1.setPrefWidth(100.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(0.0);
        columnConstraints2.setPercentWidth(10.0);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        buttonBack.setMnemonicParsing(false);
        buttonBack.setPrefHeight(55.0);
        buttonBack.setPrefWidth(51.0);
        buttonBack.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 30;");
        buttonBack.setText("<");
        buttonBack.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonBack.setFont(new Font("System Bold", 20.0));
        GridPane.setMargin(buttonBack, new Insets(0.0, 0.0, 0.0, 10.0));

        GridPane.setColumnIndex(buttonRecord, 2);
        buttonRecord.setMnemonicParsing(false);
        buttonRecord.setPrefHeight(40.0);
        buttonRecord.setStyle("-fx-background-color: #FF4948;");
        buttonRecord.setText("Record");
        buttonRecord.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonRecord.setFont(new Font("Showcard Gothic", 12.0));
        buttonRecord.setPadding(new Insets(0.0, 20.0, 0.0, 20.0));

        GridPane.setColumnIndex(label, 1);
        label.setMinHeight(0.0);
        label.setMinWidth(0.0);
        label.setText("Your Online Friends");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4948"));
        label.setFont(new Font("Showcard Gothic", 40.0));

        GridPane.setRowIndex(gridPane0, 1);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(0.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPercentWidth(60.0);
        columnConstraints4.setPrefWidth(100.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMinWidth(20.0);
        columnConstraints5.setPercentWidth(30.0);
        columnConstraints5.setPrefWidth(20.0);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(flowPane, 1);
        flowPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);

        labelLocalPlayerName.setPrefHeight(40.0);
        labelLocalPlayerName.setPrefWidth(500.0);
        labelLocalPlayerName.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName.setText("Player Name");
        labelLocalPlayerName.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        FlowPane.setMargin(labelLocalPlayerName, new Insets(0.0, 0.0, 15.0, 0.0));
        labelLocalPlayerName.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName.setOpaqueInsets(new Insets(0.0));

        labelLocalPlayerName1.setPrefHeight(40.0);
        labelLocalPlayerName1.setPrefWidth(500.0);
        labelLocalPlayerName1.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName1.setText("Player Name");
        labelLocalPlayerName1.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        labelLocalPlayerName1.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName1.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName1.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(labelLocalPlayerName1, new Insets(0.0, 0.0, 15.0, 0.0));

        labelLocalPlayerName2.setPrefHeight(40.0);
        labelLocalPlayerName2.setPrefWidth(500.0);
        labelLocalPlayerName2.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName2.setText("Player Name");
        labelLocalPlayerName2.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        labelLocalPlayerName2.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName2.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName2.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(labelLocalPlayerName2, new Insets(0.0, 0.0, 15.0, 0.0));

        labelLocalPlayerName3.setPrefHeight(40.0);
        labelLocalPlayerName3.setPrefWidth(500.0);
        labelLocalPlayerName3.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName3.setText("Player Name");
        labelLocalPlayerName3.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        labelLocalPlayerName3.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName3.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName3.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(labelLocalPlayerName3, new Insets(0.0, 0.0, 15.0, 0.0));

        labelLocalPlayerName4.setPrefHeight(40.0);
        labelLocalPlayerName4.setPrefWidth(500.0);
        labelLocalPlayerName4.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName4.setText("Player Name");
        labelLocalPlayerName4.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        labelLocalPlayerName4.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName4.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName4.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(labelLocalPlayerName4, new Insets(0.0, 0.0, 15.0, 0.0));

        labelLocalPlayerName5.setPrefHeight(40.0);
        labelLocalPlayerName5.setPrefWidth(500.0);
        labelLocalPlayerName5.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName5.setText("Player Name");
        labelLocalPlayerName5.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        labelLocalPlayerName5.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName5.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName5.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(labelLocalPlayerName5, new Insets(0.0, 0.0, 15.0, 0.0));

        labelLocalPlayerName6.setPrefHeight(40.0);
        labelLocalPlayerName6.setPrefWidth(500.0);
        labelLocalPlayerName6.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName6.setText("Player Name");
        labelLocalPlayerName6.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        labelLocalPlayerName6.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName6.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName6.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(labelLocalPlayerName6, new Insets(0.0, 0.0, 15.0, 0.0));

        labelLocalPlayerName7.setPrefHeight(40.0);
        labelLocalPlayerName7.setPrefWidth(500.0);
        labelLocalPlayerName7.setStyle("-fx-background-color: #5A5A5A;");
        labelLocalPlayerName7.setText("Player Name");
        labelLocalPlayerName7.setTextFill(javafx.scene.paint.Color.valueOf("#febf00"));
        labelLocalPlayerName7.setFont(new Font("System Bold", 14.0));
        labelLocalPlayerName7.setPadding(new Insets(0.0, 200.0, 0.0, 200.0));
        labelLocalPlayerName7.setOpaqueInsets(new Insets(0.0));
        FlowPane.setMargin(labelLocalPlayerName7, new Insets(0.0, 0.0, 15.0, 0.0));

        GridPane.setColumnIndex(flowPane0, 2);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(200.0);

        buttonChallenge.setMnemonicParsing(false);
        buttonChallenge.setPrefHeight(40.0);
        buttonChallenge.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge.setText("Challenge");
        buttonChallenge.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        FlowPane.setMargin(buttonChallenge, new Insets(0.0, 0.0, 15.0, 0.0));
        buttonChallenge.setFont(new Font("System Bold", 14.0));

        buttonChallenge1.setMnemonicParsing(false);
        buttonChallenge1.setPrefHeight(40.0);
        buttonChallenge1.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge1.setText("Challenge");
        buttonChallenge1.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonChallenge1.setFont(new Font("System Bold", 14.0));
        FlowPane.setMargin(buttonChallenge1, new Insets(0.0, 0.0, 15.0, 0.0));

        buttonChallenge2.setMnemonicParsing(false);
        buttonChallenge2.setPrefHeight(40.0);
        buttonChallenge2.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge2.setText("Challenge");
        buttonChallenge2.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonChallenge2.setFont(new Font("System Bold", 14.0));
        FlowPane.setMargin(buttonChallenge2, new Insets(0.0, 0.0, 15.0, 0.0));

        buttonChallenge3.setMnemonicParsing(false);
        buttonChallenge3.setPrefHeight(40.0);
        buttonChallenge3.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge3.setText("Challenge");
        buttonChallenge3.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonChallenge3.setFont(new Font("System Bold", 14.0));
        FlowPane.setMargin(buttonChallenge3, new Insets(0.0, 0.0, 15.0, 0.0));

        buttonChallenge4.setMnemonicParsing(false);
        buttonChallenge4.setPrefHeight(40.0);
        buttonChallenge4.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge4.setText("Challenge");
        buttonChallenge4.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonChallenge4.setFont(new Font("System Bold", 14.0));
        FlowPane.setMargin(buttonChallenge4, new Insets(0.0, 0.0, 15.0, 0.0));

        buttonChallenge5.setMnemonicParsing(false);
        buttonChallenge5.setPrefHeight(40.0);
        buttonChallenge5.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge5.setText("Challenge");
        buttonChallenge5.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonChallenge5.setFont(new Font("System Bold", 14.0));
        FlowPane.setMargin(buttonChallenge5, new Insets(0.0, 0.0, 15.0, 0.0));

        buttonChallenge6.setMnemonicParsing(false);
        buttonChallenge6.setPrefHeight(40.0);
        buttonChallenge6.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge6.setText("Challenge");
        buttonChallenge6.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonChallenge6.setFont(new Font("System Bold", 14.0));
        FlowPane.setMargin(buttonChallenge6, new Insets(0.0, 0.0, 15.0, 0.0));

        buttonChallenge7.setMnemonicParsing(false);
        buttonChallenge7.setPrefHeight(40.0);
        buttonChallenge7.setStyle("-fx-background-color: #FF4948; -fx-background-radius: 7;");
        buttonChallenge7.setText("Challenge");
        buttonChallenge7.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonChallenge7.setFont(new Font("System Bold", 14.0));
        FlowPane.setMargin(buttonChallenge7, new Insets(0.0, 0.0, 15.0, 0.0));

        getColumnConstraints().add(columnConstraints);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(buttonBack);
        gridPane.getChildren().add(buttonRecord);
        gridPane.getChildren().add(label);
        getChildren().add(gridPane);
        gridPane0.getColumnConstraints().add(columnConstraints3);
        gridPane0.getColumnConstraints().add(columnConstraints4);
        gridPane0.getColumnConstraints().add(columnConstraints5);
        gridPane0.getRowConstraints().add(rowConstraints2);
        flowPane.getChildren().add(labelLocalPlayerName);
        flowPane.getChildren().add(labelLocalPlayerName1);
        flowPane.getChildren().add(labelLocalPlayerName2);
        flowPane.getChildren().add(labelLocalPlayerName3);
        flowPane.getChildren().add(labelLocalPlayerName4);
        flowPane.getChildren().add(labelLocalPlayerName5);
        flowPane.getChildren().add(labelLocalPlayerName6);
        flowPane.getChildren().add(labelLocalPlayerName7);
        gridPane0.getChildren().add(flowPane);
        flowPane0.getChildren().add(buttonChallenge);
        flowPane0.getChildren().add(buttonChallenge1);
        flowPane0.getChildren().add(buttonChallenge2);
        flowPane0.getChildren().add(buttonChallenge3);
        flowPane0.getChildren().add(buttonChallenge4);
        flowPane0.getChildren().add(buttonChallenge5);
        flowPane0.getChildren().add(buttonChallenge6);
        flowPane0.getChildren().add(buttonChallenge7);
        gridPane0.getChildren().add(flowPane0);
        getChildren().add(gridPane0);

    }
}
