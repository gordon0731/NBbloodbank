/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.*;
import javax.swing.*;
import domain.*;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class DonationDA {
    private String host = "jdbc:derby://localhost:1527/BloodBank";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Donation";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private BookingDA booking;
    
    public DonationDA(){
        createConnection();
    }
    
    
    
     private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
