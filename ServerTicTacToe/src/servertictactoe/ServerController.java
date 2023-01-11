package servertictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ServerController implements Initializable {

    @FXML
    private Button serverOnOffButton;
    @FXML
    private TableView<Player> tableView;
    @FXML
    private TableColumn<Player, String> tableColumnName;
    @FXML
    private TableColumn<Player, String> tableColumnStatus;
    @FXML
    private TableColumn<Player, Integer> tableColumnScore;
    @FXML
    private TableColumn<Player, Integer> tableColumnNumGames;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //ObservableList playersList = ??List from database;
            //tableView.setItems(playersList);
            tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            tableColumnScore.setCellValueFactory(new PropertyValueFactory<>("totalScore"));
            tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("playerStatus"));
            tableColumnNumGames.setCellValueFactory(new PropertyValueFactory<>("numPlayedGames"));
 
    }
        
}
