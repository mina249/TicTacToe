package servertictactoe;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public abstract class ServerBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final Button ButtonStartServer;
    protected final Button ButtonStopServer;

    public ServerBase() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        ButtonStartServer = new Button();
        ButtonStopServer = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1200.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        ButtonStartServer.setMnemonicParsing(false);
        ButtonStartServer.setStyle("-fx-background-color: Green;");
        ButtonStartServer.setText("Start Server");
        ButtonStartServer.setTextFill(javafx.scene.paint.Color.WHITE);
        GridPane.setMargin(ButtonStartServer, new Insets(0.0, 0.0, 0.0, 150.0));

        GridPane.setColumnIndex(ButtonStopServer, 1);
        ButtonStopServer.setMnemonicParsing(false);
        ButtonStopServer.setStyle("-fx-background-color: Red;");
        ButtonStopServer.setText("Stop Server");
        ButtonStopServer.setTextFill(javafx.scene.paint.Color.WHITE);
        GridPane.setMargin(ButtonStopServer, new Insets(0.0, 0.0, 0.0, 150.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getRowConstraints().add(rowConstraints);
        getChildren().add(ButtonStartServer);
        getChildren().add(ButtonStopServer);

    }
}
