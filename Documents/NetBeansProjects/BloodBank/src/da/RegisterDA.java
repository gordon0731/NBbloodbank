/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import java.sql.*;
import javax.swing.*;
import domain.RegisterDO;
/**
 *
 * @author User
 */
public class RegisterDA {
    private String host = "jdbc:derby://localhost:1527/BloodBank";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "DONOR";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public RegisterDA(){
        createConnection();
    }
    public RegisterDO getRecord(String id){
        String get = "SELECT * FROM "+tableName +" WHERE DONORID =?";
        RegisterDO reg = null;
        try{
            stmt = conn.prepareStatement(get);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                reg = new RegisterDO(rs.getString("DonorID"),rs.getString("DonorName"),rs.getString("DonorNRIC"),rs.getString("Gender").charAt(0),rs.getString("Address"),rs.getString("ContactNo"),rs.getString("Email"),rs.getString("BloodType"),rs.getString("Password"),rs.getString("SecQuestion"),rs.getString("SecAnswer"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return reg;
    }
     
   
     public RegisterDO getLoginRecord(String id){
        String get = "SELECT * FROM "+tableName +" WHERE DonorID =?";
        RegisterDO reg = null;
        try{
            stmt = conn.prepareStatement(get);
            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                reg = new RegisterDO(rs.getString("DonorID"),rs.getString("DonorName"),rs.getString("Password"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return reg;
    }
    public RegisterDO getRecoveryRecord(String email){
        String get = "SELECT * FROM "+tableName +" WHERE EMAIL =?";
        RegisterDO reg = null;
        
        int i=0;
        try{
            stmt = conn.prepareStatement(get);
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                
                reg = new RegisterDO(rs.getString("DonorID"),rs.getString("Email"),rs.getString("Password"),rs.getString("SecQuestion"),rs.getString("SECANSWER"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return reg;
    }
    
    public RegisterDO getLastRecord(){
        String query = "select * from " + tableName;
        RegisterDO reg = null;
        
        try{
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                reg = new RegisterDO();
                reg = new RegisterDO(rs.getString("DonorID"),rs.getString("Password"),rs.getString("DonorName"));
            }
        }catch(SQLException ex ){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return reg;
    }
    public void addRecord(RegisterDO register){
        String add = "INSERT INTO "+tableName+" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            stmt=conn.prepareStatement(add);
            stmt.setString(1, register.getDonorid());
            stmt.setString(2, register.getDonorname());
            stmt.setString(3, register.getDonoric());
            stmt.setString(4, String.valueOf(register.getGender()));
            stmt.setString(5, register.getAddress());
            stmt.setString(6, register.getContact());
            stmt.setString(7, register.getEmail());
            stmt.setString(8, register.getBlood());
            stmt.setString(9, register.getPassword());
            stmt.setString(10, register.getSecq());
            stmt.setString(11, register.getSecans());
            stmt.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    public void updateRecord(RegisterDO register) {
       String insertStr = "UPDATE " + tableName + " SET Password = ? WHERE DONORID = ?"; 
       try {
                stmt = conn.prepareStatement(insertStr);
                    
                stmt.setString(2, register.getDonorid());
                stmt.setString(1, register.getPassword());
                    
                    
                    stmt.executeUpdate();
            }
       catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
    }

    
     private void createConnection(){
        try{
            conn = DriverManager.getConnection(host,user,password);
            System.out.println("***TRACE: Connection established.");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR!!",JOptionPane.ERROR_MESSAGE);
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
    public static void main(String[] args){
        RegisterDA da = new RegisterDA();
        RegisterDO reg = da.getLastRecord();
        System.out.println(reg);
        
    }
}
