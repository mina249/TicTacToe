package servertictactoe;

import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerTicTacToe extends Application {

// Database Url is:  "jdbc:derby://localhost:1527/serverdatabase"
// Database Driver Class is: "org.apache.derby.jdbc.ClientDriver"    
// User is "root"
// Password is "root"
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("Server.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
