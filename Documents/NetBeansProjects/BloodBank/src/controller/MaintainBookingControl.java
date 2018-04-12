package controller;

import da.BookingDA;
import domain.Booking;

public class MaintainBookingControl {

    private BookingDA bookDA;

    public MaintainBookingControl() {
        bookDA = new BookingDA();
    }

    public Booking selectRecord(String BookingID) {
        return bookDA.getRecord(BookingID);
    }
    public Booking selectLastRecord(){
        return bookDA.getLastRecord();
    }
    public Booking selectMonthRecord(String id) {
        return bookDA.getMonthRecord(id);
    }
    
    public void addRecord(Booking booking){
        bookDA.addRecord(booking);
    }
        public void deleteRecord(Booking booking){
            bookDA.deleteRecord(booking);
        }
        public void updateRecord(Booking booking){
            bookDA.updateRecord(booking);
    }

     
    
}
