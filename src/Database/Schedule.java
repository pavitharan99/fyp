/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MSI-PC
 */
@Entity
@Table(name = "SCHEDULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s")
    , @NamedQuery(name = "Schedule.findBySchid", query = "SELECT s FROM Schedule s WHERE s.schid = :schid")
    , @NamedQuery(name = "Schedule.findBySchDate", query = "SELECT s FROM Schedule s WHERE s.schDate = :schDate")
    , @NamedQuery(name = "Schedule.findBySchTime", query = "SELECT s FROM Schedule s WHERE s.schTime = :schTime")})
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SCHID")
    private String schid;

    @Column(name = "SCH_TIME")
    @Temporal(TemporalType.TIME)
    private Date schTime;
    @OneToMany(mappedBy = "schid")
    private List<NurseInCharge> nurseInChargeList;

    public Schedule() {
    }

    public Schedule(String schID, Date schTime){
        this.schid = schID;
  
        this.schTime = schTime;
    }
    
    public Schedule(String schid) {
        this.schid = schid;
    }

    public String getSchid() {
        return schid;
    }

    public void setSchid(String schid) {
        this.schid = schid;
    }


    public Date getSchTime() {
        return schTime;
    }

    public void setSchTime(Date schTime) {
        this.schTime = schTime;
    }

    @XmlTransient
    public List<NurseInCharge> getNurseInChargeList() {
        return nurseInChargeList;
    }

    public void setNurseInChargeList(List<NurseInCharge> nurseInChargeList) {
        this.nurseInChargeList = nurseInChargeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schid != null ? schid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.schid == null && other.schid != null) || (this.schid != null && !this.schid.equals(other.schid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Schedule[ schid=" + schid + " ]";
    }
    
}
