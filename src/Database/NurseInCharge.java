/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MSI-PC
 */
@Entity
@Table(name = "NURSE_IN_CHARGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NurseInCharge.findAll", query = "SELECT n FROM NurseInCharge n")
    , @NamedQuery(name = "NurseInCharge.findByStmid", query = "SELECT n FROM NurseInCharge n WHERE n.stmid = :stmid")
    , @NamedQuery(name = "NurseInCharge.findByNurseName", query = "SELECT n FROM NurseInCharge n WHERE n.nurseName = :nurseName")
    , @NamedQuery(name = "NurseInCharge.findByNurseContactnum", query = "SELECT n FROM NurseInCharge n WHERE n.nurseContactnum = :nurseContactnum")})
public class NurseInCharge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STMID")
    private String stmid;
    @Column(name = "NURSE_NAME")
    private String nurseName;
    @Column(name = "NURSE_CONTACTNUM")
    private String nurseContactnum;
    @JoinColumn(name = "SCHID", referencedColumnName = "SCHID")
    @ManyToOne
    private Schedule schid;
    @JoinColumn(name = "STMID", referencedColumnName = "STMID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private StaffAndManagement staffAndManagement;

    public NurseInCharge() {
    }
        public NurseInCharge(StaffAndManagement stmID, String nurseName, String nurseContactnum, Schedule schID) {
        this.stmid= stmID;
        this.nurseName = nurseName;
        this.nurseContactnum = nurseContactnum;
      
    }

    public NurseInCharge(String stmid) {
        this.stmid = stmid;
    }

    public String getStmid() {
        return stmid;
    }

    public void setStmid(String stmid) {
        this.stmid = stmid;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getNurseContactnum() {
        return nurseContactnum;
    }

    public void setNurseContactnum(String nurseContactnum) {
        this.nurseContactnum = nurseContactnum;
    }

    public Schedule getSchid() {
        return schid;
    }

    public void setSchid(Schedule schid) {
        this.schid = schid;
    }

    public StaffAndManagement getStaffAndManagement() {
        return staffAndManagement;
    }

    public void setStaffAndManagement(StaffAndManagement staffAndManagement) {
        this.staffAndManagement = staffAndManagement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stmid != null ? stmid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NurseInCharge)) {
            return false;
        }
        NurseInCharge other = (NurseInCharge) object;
        if ((this.stmid == null && other.stmid != null) || (this.stmid != null && !this.stmid.equals(other.stmid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.NurseInCharge[ stmid=" + stmid + " ]";
    }
    
}
