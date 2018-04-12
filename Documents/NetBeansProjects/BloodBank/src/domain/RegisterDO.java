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
public class RegisterDO {
    private String donorid;
    private String donorname;
    private String donoric;
    private char gender;
    private String address;
    private String contact;
    private String email;
    private String blood;
    private String password;
    private String secq;
    private String secans;

    public RegisterDO() {
    }

    public RegisterDO(String donorid) {
        this.donorid = donorid;
    }
    public RegisterDO(String donorid,String donorname,String password){
        this.donorid=donorid;
        this.donorname=donorname;
        this.password=password;
    }
    public RegisterDO(String donorid,String donorname,String donoric,char gender ,String address, String contact, String email, String blood,String password,String secq,String secans){
        this.donorid=donorid;
        this.donorname = donorname;
        this.donoric = donoric;
        this.gender=gender;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.blood = blood;
        this.password=password;
        this.secq=secq;
        this.secans=secans;
    }
    public RegisterDO(String donorid,String email,String password,String secq,String secans){
        this.donorid=donorid;
        this.email=email;
        this.password=password;
        this.secq=secq;
        this.secans=secans;
    
}

    public RegisterDO(String donorid,String donoric,String donorname,char gender,String address, String contact, String email, String blood) {
        
        this.donorid=donorid;
        this.donorname = donorname;
        this.donoric = donoric;
        this.gender=gender;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.blood = blood;
    }

    public String getDonorid() {
        return donorid;
    }

    public void setDonorid(String donorid) {
        this.donorid = donorid;
    }

    public String getDonorname() {
        return donorname;
    }

    public void setDonorname(String donorname) {
        this.donorname = donorname;
    }

    public String getDonoric() {
        return donoric;
    }

    public void setDonoric(String donoric) {
        this.donoric = donoric;
    }

    

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

   

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecq() {
        return secq;
    }

    public void setSecq(String secq) {
        this.secq = secq;
    }

    public String getSecans() {
        return secans;
    }

    public void setSecans(String secans) {
        this.secans = secans;
    }
    

    @Override

    public String toString() {
        return "RegisterDO{" + "donorid=" + donorid + ", donorname=" + donorname + ", donoric=" + donoric + ", gender=" + gender + ", address=" + address + ", contact=" + contact + ", email=" + email + ", blood=" + blood + ", password=" + password + ", secq=" + secq + ", secans=" + secans + '}';
    }


   
    
    
    
}
