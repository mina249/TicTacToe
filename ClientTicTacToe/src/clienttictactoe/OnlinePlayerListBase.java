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
    protected final FlowPane flowPane0;
    protected final Button buttonChallenge;

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
        flowPane0 = new FlowPane();
        buttonChallenge = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1200.0);
        setStyle("-fx-background-color: RGB(31,49,115);");

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
        columnConstraints0.setMinWidth(5.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(0.0);
        columnConstraints1.setPercentWidth(55.0);
        columnConstraints1.setPrefWidth(100.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(15.0);
        columnConstraints2.setPercentWidth(20.0);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        buttonBack.setMnemonicParsing(false);
        buttonBack.setPrefHeight(40.0);
        buttonBack.setStyle("-fx-background-color: RGB(31,49,115);");
        buttonBack.setText("<");
        buttonBack.setTextFill(javafx.scene.paint.Color.valueOf("#5a5a5a"));
        buttonBack.setFont(new Font("Arial Bold", 36.0));
        GridPane.setMargin(buttonBack, new Insets(0.0, 0.0, 0.0, 10.0));

        GridPane.setColumnIndex(buttonRecord, 2);
        buttonRecord.setMnemonicParsing(false);
        buttonRecord.setPrefHeight(40.0);
        buttonRecord.setStyle("-fx-background-color: RGB(255,73,72);");
        buttonRecord.setText("Record");
        buttonRecord.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        buttonRecord.setFont(new Font("Showcard Gothic", 12.0));

        GridPane.setColumnIndex(label, 1);
        label.setMinHeight(0.0);
        label.setMinWidth(0.0);
        label.setText("Your Online Friends");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#ff4a4a"));
        label.setFont(new Font("Showcard Gothic", 24.0));

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
        labelLocalPlayerName.setStyle("-fx-background-color: RGB(90,90,90);");
        labelLocalPlayerName.setText("Player Name");
        labelLocalPlayerName.setTextFill(javafx.scene.paint.Color.valueOf("#fd9727"));
        FlowPane.setMargin(labelLocalPlayerName, new Insets(0.0, 0.0, 15.0, 0.0));
        labelLocalPlayerName.setFont(new Font("System Bold", 14.0));

        GridPane.setColumnIndex(flowPane0, 2);
        flowPane0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        flowPane0.setPrefHeight(200.0);
        flowPane0.setPrefWidth(200.0);

        buttonChallenge.setMnemonicParsing(false);
        buttonChallenge.setPrefHeight(40.0);
        buttonChallenge.setStyle("-fx-background-color: RGB(255,73,72);");
        buttonChallenge.setText("Challenge");
        buttonChallenge.setTextFill(javafx.scene.paint.Color.valueOf("#d9d9d9"));
        FlowPane.setMargin(buttonChallenge, new Insets(0.0, 0.0, 15.0, 0.0));
        buttonChallenge.setFont(new Font("System Bold", 14.0));

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
        gridPane0.getChildren().add(flowPane);
        flowPane0.getChildren().add(buttonChallenge);
        gridPane0.getChildren().add(flowPane0);
        getChildren().add(gridPane0);

    }
}
