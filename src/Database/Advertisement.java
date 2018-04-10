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
@Table(name = "ADVERTISEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advertisement.findAll", query = "SELECT a FROM Advertisement a")
    , @NamedQuery(name = "Advertisement.findByAdid", query = "SELECT a FROM Advertisement a WHERE a.adid = :adid")
    , @NamedQuery(name = "Advertisement.findByAdName", query = "SELECT a FROM Advertisement a WHERE a.adName = :adName")
    , @NamedQuery(name = "Advertisement.findByAdDate", query = "SELECT a FROM Advertisement a WHERE a.adDate = :adDate")})
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ADID")
    private String adid;
    @Column(name = "AD_NAME")
    private String adName;
    @Column(name = "AD_DATE")
    @Temporal(TemporalType.DATE)
    private Date adDate;
    @OneToMany(mappedBy = "adid")
    private List<StaffAndManagement> staffAndManagementList;

    public Advertisement() {
    }
    public Advertisement(String Adid, String AD_name, Date AD_Date){
      this.adid=Adid;
      this.adName=AD_name;
      this.adDate=AD_Date;
    }

    public Advertisement(String adid) {
        this.adid = adid;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public Date getAdDate() {
        return adDate;
    }

    public void setAdDate(Date adDate) {
        this.adDate = adDate;
    }

    @XmlTransient
    public List<StaffAndManagement> getStaffAndManagementList() {
        return staffAndManagementList;
    }

    public void setStaffAndManagementList(List<StaffAndManagement> staffAndManagementList) {
        this.staffAndManagementList = staffAndManagementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adid != null ? adid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advertisement)) {
            return false;
        }
        Advertisement other = (Advertisement) object;
        if ((this.adid == null && other.adid != null) || (this.adid != null && !this.adid.equals(other.adid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Advertisement[ adid=" + adid + " ]";
    }
    
}
