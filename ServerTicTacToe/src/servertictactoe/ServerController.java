package servertictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ServerController implements Initializable {

    @FXML
    private Button serverOnOffButton;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> tableColumnName;
    @FXML
    private TableColumn<?, ?> tableColumnStatus;
    @FXML
    private TableColumn<?, ?> tableColumnScore;
    @FXML
    private TableColumn<?, ?> tableColumnNumGames;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
