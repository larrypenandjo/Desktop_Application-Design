/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Larry
 */
public class DBConnection {
    private String username = "root";
    private String password = "Tchoufack24";
    private String url = "jdbc:mysql://localhost:3306/homework";
    
    public Connection getConnection(){
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
