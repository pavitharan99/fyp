/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Database.Donor;
import domain.donor;
/**
/**
 *
 * @author zxchia
 */
public class ControllerDonor {
    private donor dr;
       
    public ControllerDonor () {
        dr= new donor();
    }

    public Donor selectRecord(String donorID) {
        return dr.getRecord(donorID);
    }

    public void addRecord(Donor donor){
        dr.addRecord(donor);
    }
    public void updateRecord(Donor donor){
        dr.updateRecord(donor);
    }
    public void deleteRecord(Donor donor){
        dr.deleteRecord(donor);
}
}
