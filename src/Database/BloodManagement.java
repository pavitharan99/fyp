/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MSI-PC
 */
@Entity
@Table(name = "BLOOD_MANAGEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BloodManagement.findAll", query = "SELECT b FROM BloodManagement b")
    , @NamedQuery(name = "BloodManagement.findByBloodid", query = "SELECT b FROM BloodManagement b WHERE b.bloodid = :bloodid")
    , @NamedQuery(name = "BloodManagement.findByBloodGroup", query = "SELECT b FROM BloodManagement b WHERE b.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "BloodManagement.findByBloodPackQuantity", query = "SELECT b FROM BloodManagement b WHERE b.bloodPackQuantity = :bloodPackQuantity")})
public class BloodManagement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BLOODID")
    private String bloodid;
    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;
    @Column(name = "BLOOD_PACK_QUANTITY")
    private Integer bloodPackQuantity;
    @OneToMany(mappedBy = "bloodid")
    private List<BloodDonation> bloodDonationList;

    public BloodManagement() {
    }

    public BloodManagement(String bloodid) {
        this.bloodid = bloodid;
    }

    public String getBloodid() {
        return bloodid;
    }

    public void setBloodid(String bloodid) {
        this.bloodid = bloodid;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Integer getBloodPackQuantity() {
        return bloodPackQuantity;
    }

    public void setBloodPackQuantity(Integer bloodPackQuantity) {
        this.bloodPackQuantity = bloodPackQuantity;
    }

    @XmlTransient
    public List<BloodDonation> getBloodDonationList() {
        return bloodDonationList;
    }

    public void setBloodDonationList(List<BloodDonation> bloodDonationList) {
        this.bloodDonationList = bloodDonationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bloodid != null ? bloodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloodManagement)) {
            return false;
        }
        BloodManagement other = (BloodManagement) object;
        if ((this.bloodid == null && other.bloodid != null) || (this.bloodid != null && !this.bloodid.equals(other.bloodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.BloodManagement[ bloodid=" + bloodid + " ]";
    }
    
}
