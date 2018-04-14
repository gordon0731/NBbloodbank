package controller;

import da.BloodDA;
import domain.Blood;

public class MaintainBloodControl {

    private BloodDA bloodDA;

    public MaintainBloodControl() {
        bloodDA = new BloodDA();
    }

    public Blood selectRecord(String BloodID) {
        return bloodDA.getRecord(BloodID);
    }
    
    public void addRecord(Blood blood){
        bloodDA.addRecord(blood);
    }
        public void deleteRecord(Blood blood){
            bloodDA.deleteRecord(blood);
        }
        public void updateRecord(Blood blood){
            bloodDA.updateRecord(blood);
    }

        public Blood selectLastRecord(){
            return bloodDA.getLastRecord();
    }
    
}
