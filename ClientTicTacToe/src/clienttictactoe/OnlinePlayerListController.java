package clienttictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class OnlinePlayerListController implements Initializable {

    @FXML
    private Button buttonBack;
    @FXML
    private Button buttonRecord;
 /*
    @FXML
    private TableView<Player> tableView;
    @FXML
    private TableColumn<Player, String> tableColumnOnline;
*/
    @FXML
    private Button buttonSendInvite;
    @FXML
    private Button buttonRefresh;

    @FXML
    public void handleLogoutButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void handleSendInviteButtonAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Board scr.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
         stage.setScene(scene);
        stage.show();   
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
