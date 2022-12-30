package clienttictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientTicTacToe extends Application {
    
// Database Url is:  "jdbc:derby://localhost:1527/clientdatabase"
// Database Driver Class is: "org.apache.derby.jdbc.ClientDriver"    
// User is "root"
// Password is "root"
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HomePageScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
