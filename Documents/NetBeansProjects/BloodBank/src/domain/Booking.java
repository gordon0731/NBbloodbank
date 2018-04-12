package domain;

import java.io.Serializable;
import java.util.Objects;
import java.sql.Date;
import java.sql.Time;
import java.sql.*;


public class Booking implements Serializable {
    private String BookingID;
    private Date Date;
    private Time Time;
    private String RoomNo;
    private RegisterDO DonorID;
    private Staff StaffID;
    private String bookingStatus;

    public Booking() {
    }

    public Booking(Date date) {
        this.Date=date;
    }
    public Booking(String BookingID){
        this.BookingID=BookingID;
    }

    public Booking(String BookingID,Date date, Time time, String RoomNo, RegisterDO DonorID, Staff StaffID, String bookingStatus) {
        this.BookingID = BookingID;
        this.Date = date;
        this.Time = time;
        this.RoomNo = RoomNo;
        this.DonorID = DonorID;
        this.StaffID = StaffID;
        this.bookingStatus = bookingStatus;
    }
   

    public String getBookingID() {
        return BookingID;
    }

    public Date getDate() {
        return Date;
    }

    
    
    public String getRoomNo() {
        return RoomNo;
    }

    public RegisterDO getDonorID() {
        return DonorID;
    }

    public Staff getStaffID() {
        return StaffID;
    }

    public String getbookingStatus() {
        return bookingStatus;
    }

    public void setBookingID(String BookingID) {
        this.BookingID = BookingID;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    

    public void setRoomNo(String RoomNo) {
        this.RoomNo = RoomNo;
    }

    public void setDonorID(RegisterDO DonorID) {
        this.DonorID = DonorID;
    }

    public void setStaffID(Staff StaffID) {
        this.StaffID = StaffID;
    }

    public void setbookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    
    /*@Override
    public String toString() {
        return String.format("%-5s %-50s %-10s", code, name, faculty);
    }*/

    @Override

    public String toString() {
        return "Booking{" + "BookingID=" + BookingID + ", Date=" + Date + ", Time=" + Time + ", RoomNo=" + RoomNo + ", DonorID=" + DonorID + ", StaffID=" + StaffID + ", bookingStatus=" + bookingStatus + '}';
    }
   
    
    
    
}
