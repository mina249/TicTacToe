package clienttictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private String loggedUserName;
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

    Thread thread;

    ClientSide cs;
    StringTokenizer tokenizer;

    @FXML
    public void handleLogoutButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleSendInviteButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Board scr.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cs = new ClientSide();
   
    }

    public void getLoginName(String loggedUserName) {
        this.loggedUserName = loggedUserName;
    }

    public void acceptingOnlineList() {

        thread = new Thread(() -> {
            while (true) {
                try {
                    String CompleteMsg = cs.dis.readLine();
                    tokenizer = new StringTokenizer(CompleteMsg, ";");
                    String headerMsg = tokenizer.nextToken();
                    switch (headerMsg) {
                        case "request":
                            break;
                        case "onlinePlayers":
                            String[] allOnlinePlayers = CompleteMsg.split(";");
                            for (int i = 0; i < allOnlinePlayers.length; i++) {
                                System.out.println(allOnlinePlayers[i]);
                            }
                            break;
                        default:
                            break;

                    }
                } catch (IOException ex) {
                    Logger.getLogger(OnlinePlayerListController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        thread.start();

    }
}
