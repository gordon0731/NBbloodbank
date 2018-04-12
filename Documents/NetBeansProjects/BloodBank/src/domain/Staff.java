package domain;

import java.io.Serializable;
import java.util.Objects;


public class Staff implements Serializable {
    private String StaffID;
    private String StaffName;
    private String StaffNRIC;
    private char Gender;
    private int Age;
    private String Address;
    private String ContactNo;
    private String Email;
    private String position;
    private String password;
    private String secQuestion;
    private String secAnswer;

    public Staff() {
    }

    public Staff(String StaffID) {
        this.StaffID = StaffID;
    }

    public Staff(String StaffID, String StaffName, String StaffNRIC, char Gender, int Age, String Address, String ContactNo, String Email, String postion, String password, String secQuestion, String secAnswer) {
        this.StaffID = StaffID;
        this.StaffName = StaffName;
        this.StaffNRIC = StaffNRIC;
        this.Gender = Gender;
        this.Age = Age;
        this.Address = Address;
        this.ContactNo = ContactNo;
        this.Email = Email;
        this.position = position;
        this.password = password;
        this.secQuestion = secQuestion;
        this.secAnswer = secAnswer;
    }

    
    
    
    

    public String getStaffID() {
        return StaffID;
    }

    public String getStaffName() {
        return StaffName;
    }

    public String getStaffNRIC() {
        return StaffNRIC;
    }

    public char getGender() {
        return Gender;
    }

    public int getAge() {
        return Age;
    }

    public String getAddress() {
        return Address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getEmail() {
        return Email;
    }
    
    public String getposition() {
        return position;
    }
    
    public String getpassword() {
        return password;
    }

    public String getsecQuestion() {
        return secQuestion;
    }
    
    public String getsecAnswer() {
        return secAnswer;
    }
    
    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setStaffName(String StaffName) {
        this.StaffName = StaffName;
    }

    public void setStaffNRIC(String StaffNRIC) {
        this.StaffNRIC = StaffNRIC;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public void setposition( String position) {
        this.position = position;
    }
    
    public void setpassword(String password) {
        this.password = password;
    }
    
    public void setsecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }
    
    public void setsecAnswer(String secAnswer) {
        this.secAnswer = secAnswer;
    }
    
    /*@Override
    public String toString() {
        return String.format("%-5s %-50s %-10s", code, name, faculty);
    }*/
    
}
