package servertictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    static Connection con = null;
    static String dbName = "serverdatabase";
    static String url = "jdbc:derby://localhost:1527/serverdatabase";   // Will it change between different laptops ?
    static String driver = "org.apache.derby.jdbc.ClientDriver";
    static String username = "root";
    static String password = "root";
 
    public static void dbConnect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url, username, password); 
    }
    // Add public methods to use in Controller
    public static ObservableList<Player> serverPlayerList() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ObservableList<Player> players = FXCollections.observableArrayList();
        Statement stmt = con.createStatement();
        String queryString = "select * from Player where status != 'Offline' order by status desc";
        ResultSet rs = stmt.executeQuery(queryString);
        while (rs.next()) {
           String name = rs.getString(2);
           String status = rs.getString(5);
           int totalScore = rs.getInt(6);
           int numPlayedGames = rs.getInt(7);
     
           Player p = new Player(name, status, totalScore, numPlayedGames);
           players.add(p);
        }  
        return players;
    }
    
    public static ObservableList<Player> onlinePlayerList() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ObservableList<Player> players = FXCollections.observableArrayList();
        Statement stmt = con.createStatement();
        String queryString = "select * from Player where status in ('Online', 'online')";
        ResultSet rs = stmt.executeQuery(queryString);
        while (rs.next()) {
           String name = rs.getString(2);
           Player p = new Player(name);
           players.add(p);
        }  
        return players;
    }  
   
}
