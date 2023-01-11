/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class DataAccessLayer {
    
    public static int signUp(String mail, String name, String password) throws SQLException
    {
        int result=0;
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection con= DriverManager.getConnection("jdbc:derby://localhost:1527/TicTacToe","root","root");
        PreparedStatement ps= con.prepareStatement("INSERT INTO PLAYER (EMAIL,USERNAME,PASSWORD) VALUES (?,?,?)");
        ps.setString(1, mail);
        ps.setString(2, name);
        ps.setString(3, password);
        result= ps.executeUpdate();
        con.commit();
        ps.close();
        con.close();
        return result;
    }
    
    public static int logIn(String name, String password) throws SQLException
    {
        int result=0;
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TicTacToe","root","root");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Contacts WHERE( USERNAME= ? and PASSWORD= ?) ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ps.setString(1, name);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
         rs.close();
         
        if (rs.next())
        {
            ps= con.prepareStatement("UPDATE PLAYER set STATUS=? where USERNAME=?");
            ps.setString(1, "online");
            ps.setString(2, name);
            result=1;
        }
        con.commit();
        ps.close();
        con.close();
        return result;
    }
    
}

