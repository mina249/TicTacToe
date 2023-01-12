package servertictactoe;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Circle;
import static servertictactoe.Database.con;
import static servertictactoe.Database.dbConnect;
import static servertictactoe.Database.serverPlayerList;


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
    @FXML
    private Circle circleGreen;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

            ObservableList playersList;
        try {
            dbConnect();
            playersList = serverPlayerList();
            tableView.setItems(playersList);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
        }
            tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

            tableColumnScore.setCellValueFactory(new PropertyValueFactory<>("totalScore"));
            tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
            tableColumnNumGames.setCellValueFactory(new PropertyValueFactory<>("numPlayedGames"));
            tableColumnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
            new ServerSide();

    }
    
    public void serverOnOff() throws SQLException
    {
        //
        if(serverOnOffButton.getText().equals("Server On"))
        {
            serverOnOffButton.setText("Server Off");
            circleGreen.setVisible(false);
                    ObservableList<Player> test;
           /*
                    try {
                String str = tableView.getSelectionModel().getSelectedItem().getName();
                System.out.println(str);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
                    */

        }
        else
        {
            serverOnOffButton.setText("Server On");
            circleGreen.setVisible(true);
  /*          
        Statement stmt = con.createStatement();
        String queryStrings = "update PLAYER set status = 'Offline'";
        stmt.executeUpdate(queryStrings);
            //
*/
           
         Platform.runLater(() -> {
                try {
                    serverPlayerList();
                } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(ServerController.class.getName()).log(Level.SEVERE, null, ex);
                }      
            });           
        }
    }
}