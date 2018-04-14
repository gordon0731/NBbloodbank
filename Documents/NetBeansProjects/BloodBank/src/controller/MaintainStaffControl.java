package controller;

import da.StaffDA;
import domain.Staff;

public class MaintainStaffControl {

    private StaffDA staffDA;

    public MaintainStaffControl() {
        staffDA = new StaffDA();
    }

    public Staff selectRecord(String StaffID) {
        return staffDA.getRecord(StaffID);
    }
    
    public void addRecord(Staff staff){
        staffDA.addRecord(staff);
    }
        public void deleteRecord(Staff staff){
            staffDA.deleteRecord(staff);
        }
        public void updateRecord(Staff staff){
            staffDA.updateRecord(staff);
    }

        public Staff selectLastRecord(){
            return staffDA.getLastRecord();
    }
     
    
}
