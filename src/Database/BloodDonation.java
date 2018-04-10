/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MSI-PC
 */
@Entity
@Table(name = "BLOOD_DONATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BloodDonation.findAll", query = "SELECT b FROM BloodDonation b")
    , @NamedQuery(name = "BloodDonation.findByDonationid", query = "SELECT b FROM BloodDonation b WHERE b.donationid = :donationid")
    , @NamedQuery(name = "BloodDonation.findByDonationDate", query = "SELECT b FROM BloodDonation b WHERE b.donationDate = :donationDate")
    , @NamedQuery(name = "BloodDonation.findByStmid", query = "SELECT b FROM BloodDonation b WHERE b.stmid = :stmid")})
public class BloodDonation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DONATIONID")
    private String donationid;
    @Column(name = "DONATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date donationDate;
    @Column(name = "STMID")
    private String stmid;
    @JoinColumn(name = "BLOODID", referencedColumnName = "BLOODID")
    @ManyToOne
    private BloodManagement bloodid;
    @JoinColumn(name = "DONORID", referencedColumnName = "DONORID")
    @ManyToOne
    private Donor donorid;

    public BloodDonation() {
    }

    public BloodDonation(String donationid) {
        this.donationid = donationid;
    }

    public String getDonationid() {
        return donationid;
    }

    public void setDonationid(String donationid) {
        this.donationid = donationid;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public String getStmid() {
        return stmid;
    }

    public void setStmid(String stmid) {
        this.stmid = stmid;
    }

    public BloodManagement getBloodid() {
        return bloodid;
    }

    public void setBloodid(BloodManagement bloodid) {
        this.bloodid = bloodid;
    }

    public Donor getDonorid() {
        return donorid;
    }

    public void setDonorid(Donor donorid) {
        this.donorid = donorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donationid != null ? donationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloodDonation)) {
            return false;
        }
        BloodDonation other = (BloodDonation) object;
        if ((this.donationid == null && other.donationid != null) || (this.donationid != null && !this.donationid.equals(other.donationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.BloodDonation[ donationid=" + donationid + " ]";
    }
    
}
