/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import Database.Schedule;
import domain.schedule;
/**
/**
 *
 * @author zxchia
 */
public class ControllerSchedule {
    private schedule sch;
       
    public ControllerSchedule () {
        sch= new schedule();
    }

    public Schedule selectRecord(String schid) {
        return sch.getRecord(schid);
    }

    public void addRecord(Schedule Sch){
        sch.addRecord(Sch);
    }
    public void updateRecord(Schedule Sch){
        sch.updateRecord(Sch);
    }
    public void deleteRecord(Schedule Sch){
       sch.deleteRecord(Sch);
}
}
