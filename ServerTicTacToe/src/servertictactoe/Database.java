package servertictactoe;

import java.sql.Connection;

public class Database {
    static Connection con = null;
    static String dbName = "serverdatabase";
    static String url = "jdbc:derby://localhost:1527/serverdatabase";   // Will it change between different laptops ?
    static String driver = "org.apache.derby.jdbc.ClientDriver";
    static String username = "root";
    static String password = "root";
    
    // Add public methods to use in Controller
}
