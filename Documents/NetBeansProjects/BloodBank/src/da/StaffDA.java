package da;

import domain.Staff;
import java.sql.*;
import javax.swing.*;

public class StaffDA {
    private String host = "jdbc:derby://localhost:1527/BloodBank";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Staff";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public StaffDA() {
        createConnection();
    }

    public Staff getLastRecord(){
        String query = "select * from " + tableName;
        Staff staff = null;
        
        try{
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                //blood = new Blood();
                staff = new Staff(rs.getString("StaffID"));
            }
        }catch(SQLException ex ){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return staff;
    }
     public Staff getRecoveryRecord(String email){
        String get = "SELECT * FROM "+tableName +" WHERE EMAIL =?";
        Staff staff = null;
        
        int i=0;
        try{
            stmt = conn.prepareStatement(get);
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                
                staff = new Staff(rs.getString("StaffID"),rs.getString("Email"),rs.getString("Position"),rs.getString("SecQuestion"),rs.getString("SecAnswer"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    
    public Staff getRecord(String StaffID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE StaffID = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, StaffID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                staff = new Staff(StaffID, rs.getString("StaffName"), rs.getString("StaffNRIC"), rs.getString("Gender").charAt(0), rs.getString("Address"), rs.getString("ContactNo"), rs.getString("Email"), rs.getString("Position"), rs.getString("password"), rs.getString("secQuestion"), rs.getString("secAnswer"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    
        
     public void addRecord(Staff staff) {
       String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement(insertStr);
                stmt.setString(1, staff.getStaffID());
                stmt.setString(11, staff.getStaffName());
                stmt.setString(2, staff.getStaffNRIC());
                stmt.setString(3, String.valueOf(staff.getGender()));
                stmt.setString(4, staff.getAddress());
                stmt.setString(5, staff.getContactNo());
                stmt.setString(6, staff.getEmail());
                stmt.setString(7, staff.getposition());
                stmt.setString(8, staff.getpassword());
                stmt.setString(9, staff.getsecQuestion());
                stmt.setString(10, staff.getsecAnswer());
                stmt.executeUpdate();
              
          
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

public void deleteRecord(Staff staff){

    try{
        stmt = conn.prepareStatement("DELETE FROM Staff WHERE StaffID = ?");
        stmt.setString(1, staff.getStaffID());
        stmt.executeUpdate();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
    
    public void updateRecord(Staff staff){
        
                try{
                    
                    stmt = conn.prepareStatement("UPDATE Staff SET StaffName = ?, StaffNRIC = ?, Gender = ?, Address = ?, ContactNo = ?, Email = ?, Position = ?, Password = ?, SecQuestion = ?, SecAnswer = ? WHERE StaffID = ?");
                    stmt.setString(11, staff.getStaffID());
                    stmt.setString(1, staff.getStaffName());
                    stmt.setString(2, staff.getStaffNRIC());
                    stmt.setString(3, String.valueOf(staff.getGender()));
                    stmt.setString(4, staff.getAddress());
                    stmt.setString(5, staff.getContactNo());
                    stmt.setString(6, staff.getEmail());
                    stmt.setString(7, staff.getposition());
                    stmt.setString(8, staff.getpassword());
                    stmt.setString(9, staff.getsecQuestion());
                    stmt.setString(10, staff.getsecAnswer());
                    stmt.executeUpdate();
                }
                catch(SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
        

}
    public void updateResetRecord(Staff staff){
        String insertStr = "UPDATE " + tableName + " SET Password = ? WHERE STAFFID = ?"; 
       try {
                stmt = conn.prepareStatement(insertStr);
                    
                stmt.setString(2, staff.getStaffID());
                stmt.setString(1, staff.getpassword());
                    
                    
                    stmt.executeUpdate();
            }
       catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
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
        StaffDA da = new StaffDA();
        Staff staff = da.getRecord("SF0003");
        System.out.println(staff);
    }
}
