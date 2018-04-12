package domain;

import java.io.Serializable;
import java.util.Objects;


public class Blood implements Serializable {
    private String BloodID;
    private String BloodType;
    private int BloodQuantity;
    /*private char Gender;
    private int Age;
    private String Address;
    private String ContactNo;
    private String Email;
    private String position;
    private String password;
    private String secQuestion;
    private String secAnswer;*/

    public Blood() {
    }

    public Blood(String BloodID) {
        this.BloodID = BloodID;
    }

    public Blood(String BloodID, String BloodType, int BloodQuantity) {
        this.BloodID= BloodID;
        this.BloodType= BloodType;
        this.BloodQuantity= BloodQuantity;
    }


    public String getBloodID() {
        return BloodID;
    }

    public String getBloodType() {
        return BloodType;
    }

    public int getBloodQuantity() {
        return BloodQuantity;
    }

    public void setBloodID(String BloodID) {
        this.BloodID = BloodID;
    }

    public void setBloodType(String BloodType) {
        this.BloodType = BloodType;
    }

    public void setBloodQuantity(int BloodQuantity) {
        this.BloodQuantity = BloodQuantity;
    }

    /*@Override
    public String toString() {
        return String.format("%-5s %-50s %-10s", code, name, faculty);
    }*/

    @Override
    public String toString() {
        return "Blood{" + "BloodID=" + BloodID + ", BloodType=" + BloodType + ", BloodQuantity=" + BloodQuantity + '}';
    }

    
}
