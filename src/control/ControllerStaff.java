/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Database.StaffAndManagement;
import domain.Staff_and_Mnagement;
/**
/**
 *
 * @author zxchia
 */
public class ControllerStaff{
    private Staff_and_Mnagement stm;
       
    public ControllerStaff () {
        stm= new Staff_and_Mnagement();
    }

    public StaffAndManagement selectRecord(String StmID) {
        return stm.getRecord(StmID);
    }

    public void addRecord(StaffAndManagement staffAndManagement){
        stm.addRecord(staffAndManagement);
    }
    public void updateRecord(StaffAndManagement staffAndManagement){
        stm.updateRecord(staffAndManagement);
    }
    public void deleteRecord(StaffAndManagement staffAndManagement){
        stm.deleteRecord(staffAndManagement);
}
}
