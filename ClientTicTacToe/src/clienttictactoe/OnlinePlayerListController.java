package clienttictactoe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Label loggedName;
    Thread th;
    String msg;
    String reply;
    ClientSide cs;
    SignInController signIn= new SignInController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cs = new ClientSide();
    }
    
     public void getUserName(String name)
    {
        loggedName.setText(name);
        loggedUserName= loggedName.getText();
    }

    @FXML
    public void handleLogoutButtonAction(ActionEvent event) throws Exception {
        th = new Thread(() -> {
           while (true) {
                try {
                    msg = "logout" + ";" + loggedUserName;
                    cs.ps.println(msg);
                    reply = cs.dis.readLine();
                    if (reply.equals("1") && reply!=null) {
                        Platform.runLater(new Runnable() {
                        @Override
                            public void run() {
                            try {
                                Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                                Scene scene = new Scene(root);
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();
                            } catch (IOException ex) {
                                Logger.getLogger(OnlinePlayerListController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            }
                        });
                    }
                } catch (IOException ex) {
                    Logger.getLogger(OnlinePlayerListController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        th.start();
    }

    @FXML
    public void handleSendInviteButtonAction(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Board scr.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
