/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author User
 */
import da.*;
import domain.*;
public class MaintainRegister {
    private RegisterDA reDA;
    
    public MaintainRegister(){
        reDA = new RegisterDA();
    }
    public RegisterDO selectLastRecord(){
        return reDA.getLastRecord();
    }
    public RegisterDO selectRecoveryRecord(String email){
        return reDA.getRecoveryRecord(email);
    }
    public RegisterDO selectRecord(String id){
        return reDA.getRecord(id);
    }
    
    public RegisterDO selectLoginRecord(String id){
        return reDA.getLoginRecord(id);
    }
    public void addRecord(RegisterDO Register){
        reDA.addRecord(Register);
    }
    public void updateRecord(RegisterDO register){
        reDA.updateRecord(register);
    }
}
