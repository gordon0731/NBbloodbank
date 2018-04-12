package da;

import domain.*;
import java.sql.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;

public class BookingDA {
    private String host = "jdbc:derby://localhost:1527/BloodBank";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Booking";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private RegisterDA donorDA;
    private StaffDA staffda;
    
    public BookingDA() {
        createConnection();
        donorDA=new RegisterDA();
        staffda = new StaffDA();
    }
    
    public Booking getRecord(String BookingID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BookingID = ?";
        Booking booking = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, BookingID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                RegisterDO d = donorDA.getRecord(rs.getString("donorid"));
                Staff s = staffda.getRecord(rs.getString("staffid"));
                booking = new Booking(BookingID, rs.getDate("Date"), rs.getTime("Time"), rs.getString("RoomNo"), d, s, rs.getString("bookingStatus"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return booking;
    }
    public Booking getMonthRecord(String id){
        String query = "SELECT * FROM "+ tableName +" WHERE DonorID=? AND BookingStatus=?";
        Booking booking=null;
        try{
            
                String bs="Successful";
                stmt=conn.prepareStatement(query);
                stmt.setString(1, id);
                stmt.setString(2, bs);
                ResultSet rs = stmt.executeQuery();
            if(rs.next()){ 
                RegisterDO d = donorDA.getRecord(id);
                Staff s = staffda.getRecord(rs.getString("staffid"));
                booking = new Booking(rs.getString("BookingID"), rs.getDate("Date"), rs.getTime("Time"), rs.getString("RoomNo"), d, s, rs.getString("bookingStatus"));
                
                
            }
            
        }catch(SQLException ex){
            
        }
        return booking;
    }
    public Booking getLastRecord(){
        String query = "select * from " + tableName;
        Booking book = null;
        
        try{
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                book = new Booking();
                book = new Booking(rs.getString("BookingID"));
            }
        }catch(SQLException ex ){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return book;
    }
    
        
     public void addRecord(Booking booking) {
       String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?)";
        try {
            
            
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
              RegisterDO reg=null;
              Staff s=null;
                stmt = conn.prepareStatement(insertStr);
                stmt.setString(1, booking.getBookingID());
                stmt.setDate(2,booking.getDate());
                stmt.setTime(3, booking.getTime());
                stmt.setString(4, booking.getRoomNo());
                stmt.setString(5, booking.getDonorID().getDonorid());
                stmt.setString(6, booking.getStaffID().getStaffID());
                stmt.setString(7, booking.getBookingStatus());
                stmt.executeUpdate();
              
          
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

public void deleteRecord(Booking booking){

    try{
        stmt = conn.prepareStatement("DELETE FROM Booking WHERE BookingID = ?");
        stmt.setString(1, booking.getBookingID());
        stmt.executeUpdate();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
    
    public void updateRecord(Booking booking){
        
                try{
                    RegisterDO reg=null;
              Staff s=null;
                    stmt = conn.prepareStatement("UPDATE Booking SET Date = ?, Time = ?, RoomNo = ?, DonorID = ?, StaffID = ? WHERE BookingID = ?");
                    stmt.setString(1, booking.getBookingID());
                    stmt.setDate(2, booking.getDate());
                    stmt.setTime(3, booking.getTime());
                    stmt.setString(4, booking.getRoomNo());
                    stmt.setString(5, reg.getDonorid());
                    stmt.setString(6, s.getStaffID());
                    stmt.setString(7, booking.getbookingStatus());
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
        BookingDA da = new BookingDA();
    }
}
