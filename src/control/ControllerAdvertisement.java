/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Database.Advertisement;
import domain.advertisment;
/**
/**
 *
 * @author zxchia
 */
public class ControllerAdvertisement {
    private advertisment ad;
       
    public ControllerAdvertisement () {
        ad= new advertisment();
    }

    public Advertisement selectRecord(String Adid) {
        return ad.getRecord(Adid);
    }

    public void addRecord(Advertisement advertisement){
        ad.addRecord(advertisement);
    }
    public void updateRecord(Advertisement advertisement){
        ad.updateRecord(advertisement);
    }
    public void deleteRecord(Advertisement advertisement){
        ad.deleteRecord(advertisement);
}
}

