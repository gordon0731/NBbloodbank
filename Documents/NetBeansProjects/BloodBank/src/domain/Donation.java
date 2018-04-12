/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author User
 */
public class Donation {
    private String DonationID;
    private String Bloodtype;
    private int quantity;
    private Booking bookingID;

    public Donation() {
    }

    public Donation(String DonationID, String Bloodtype, int quantity, Booking bookingID) {
        this.DonationID = DonationID;
        this.Bloodtype = Bloodtype;
        this.quantity = quantity;
        this.bookingID = bookingID;
    }

    public String getDonationID() {
        return DonationID;
    }

    public void setDonationID(String DonationID) {
        this.DonationID = DonationID;
    }

    public String getBloodtype() {
        return Bloodtype;
    }

    public void setBloodtype(String Bloodtype) {
        this.Bloodtype = Bloodtype;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Booking getBookingID() {
        return bookingID;
    }

    public void setBookingID(Booking bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public String toString() {
        return "Donation{" + "DonationID=" + DonationID + ", Bloodtype=" + Bloodtype + ", quantity=" + quantity + ", bookingID=" + bookingID + '}';
    }
    
    
    
}
