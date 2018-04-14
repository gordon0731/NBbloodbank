package da;

import domain.Blood;
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;

public class BloodDA {
    private String host = "jdbc:derby://localhost:1527/BloodBank";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BloodBank";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public BloodDA() {
        createConnection();
    }
    
    public Blood getRecord(String BloodID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BloodID = ?";
        Blood blood = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, BloodID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                blood = new Blood(BloodID, rs.getString("BloodType"), rs.getInt("BloodQuantity"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return blood;
    }
    
    public Blood getLastRecord(){
        String query = "select * from " + tableName;
        Blood blood = null;
        
        try{
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                //blood = new Blood();
                blood = new Blood(rs.getString("BloodID"));
            }
        }catch(SQLException ex ){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return blood;
    }
    
    public ArrayList<Blood> getAllRecord(){
        
        BloodDA bDA = new BloodDA();
        ArrayList<Blood> bloodlist= new ArrayList<Blood>();
        
        String queryStr = "SELECT * FROM " + tableName ;
        Blood blood= null;
        try {
            stmt = conn.prepareStatement(queryStr);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                blood = new Blood(rs.getString("bloodid"),rs.getString("bloodtype"),rs.getInt("bloodquantity"));
                bloodlist.add(blood);
            }
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
          
        return bloodlist;
    }
        
     public void addRecord(Blood blood) {
       String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement(insertStr);
                stmt.setString(1, blood.getBloodID());
                stmt.setString(2, blood.getBloodType());
                stmt.setInt(3, blood.getBloodQuantity());
                stmt.executeUpdate();
              
          
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

public void deleteRecord(Blood blood){

    try{
        stmt = conn.prepareStatement("DELETE FROM BloodBank WHERE BloodID = ?");
        stmt.setString(1, blood.getBloodID());
        stmt.executeUpdate();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
    
    public void updateRecord(Blood blood){
        
                try{
                    
                    stmt = conn.prepareStatement("UPDATE BloodBank SET BloodType = ?, BloodQuantity = ? WHERE BloodID = ?");
                    stmt.setString(1, blood.getBloodID());
                    stmt.setString(2, blood.getBloodType());
                    stmt.setInt(3, blood.getBloodQuantity());
                    
                    stmt.executeUpdate();
                }
                catch(SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
        

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
    
    public static void main(String[] args) {
        BloodDA da = new BloodDA();
        Blood blood = da.getRecord("IA");
        System.out.println(blood);
        }
    }

