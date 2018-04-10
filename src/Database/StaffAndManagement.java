/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "STAFF_AND_MANAGEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffAndManagement.findAll", query = "SELECT s FROM StaffAndManagement s")
    , @NamedQuery(name = "StaffAndManagement.findByStmid", query = "SELECT s FROM StaffAndManagement s WHERE s.stmid = :stmid")
    , @NamedQuery(name = "StaffAndManagement.findByStmName", query = "SELECT s FROM StaffAndManagement s WHERE s.stmName = :stmName")
    , @NamedQuery(name = "StaffAndManagement.findByStmNric", query = "SELECT s FROM StaffAndManagement s WHERE s.stmNric = :stmNric")
    , @NamedQuery(name = "StaffAndManagement.findByStmContactnum", query = "SELECT s FROM StaffAndManagement s WHERE s.stmContactnum = :stmContactnum")
    , @NamedQuery(name = "StaffAndManagement.findByStmAddress", query = "SELECT s FROM StaffAndManagement s WHERE s.stmAddress = :stmAddress")
    , @NamedQuery(name = "StaffAndManagement.findByStmEmail", query = "SELECT s FROM StaffAndManagement s WHERE s.stmEmail = :stmEmail")
    , @NamedQuery(name = "StaffAndManagement.findByStmPosition", query = "SELECT s FROM StaffAndManagement s WHERE s.stmPosition = :stmPosition")
    , @NamedQuery(name = "StaffAndManagement.findByStmUsername", query = "SELECT s FROM StaffAndManagement s WHERE s.stmUsername = :stmUsername")
    , @NamedQuery(name = "StaffAndManagement.findByStmPassword", query = "SELECT s FROM StaffAndManagement s WHERE s.stmPassword = :stmPassword")})
public class StaffAndManagement implements Serializable {

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "staffAndManagement")
    private NurseInCharge nurseInCharge;

    @Column(name = "STM_SECQUESANS")
    private String stmSecquesans;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "STMID")
    private String stmid;
    @Column(name = "STM_NAME")
    private String stmName;
    @Column(name = "STM_NRIC")
    private String stmNric;
    @Column(name = "STM_CONTACTNUM")
    private String stmContactnum;
    @Column(name = "STM_ADDRESS")
    private String stmAddress;
    @Column(name = "STM_EMAIL")
    private String stmEmail;
    @Column(name = "STM_POSITION")
    private String stmPosition;
    @Column(name = "STM_USERNAME")
    private String stmUsername;
    @Column(name = "STM_PASSWORD")
    private String stmPassword;
    @JoinColumn(name = "ADID", referencedColumnName = "ADID")
    @ManyToOne
    private Advertisement adid;

    public StaffAndManagement() {
    }

    public StaffAndManagement(String stmid) {
        this.stmid = stmid;
    }
    
    public StaffAndManagement(String stmid, String stmname, String stmNRIC, String stmContactnum, String stmAddress, String stmEmail, String stmposition,String stmusername, String stmpassword, Advertisement Adid, String stmsecquesans){
        this.stmid = stmid;
        this.stmName = stmname;
        this.stmNric = stmNRIC;
        this.stmContactnum = stmContactnum;
        this.stmAddress = stmAddress;
        this.stmEmail = stmEmail;
        this.stmPosition = stmposition;
        this.stmUsername = stmusername;
        this.stmPassword = stmpassword;
        this.stmid = stmid;
        this.stmSecquesans = stmsecquesans;
        this.adid=Adid;
    }

    public String getStmid() {
        return stmid;
    }

    public void setStmid(String stmid) {
        this.stmid = stmid;
    }

    public String getStmName() {
        return stmName;
    }

    public void setStmName(String stmName) {
        this.stmName = stmName;
    }

    public String getStmNric() {
        return stmNric;
    }

    public void setStmNric(String stmNric) {
        this.stmNric = stmNric;
    }

    public String getStmContactnum() {
        return stmContactnum;
    }

    public void setStmContactnum(String stmContactnum) {
        this.stmContactnum = stmContactnum;
    }

    public String getStmAddress() {
        return stmAddress;
    }

    public void setStmAddress(String stmAddress) {
        this.stmAddress = stmAddress;
    }

    public String getStmEmail() {
        return stmEmail;
    }

    public void setStmEmail(String stmEmail) {
        this.stmEmail = stmEmail;
    }

    public String getStmPosition() {
        return stmPosition;
    }

    public void setStmPosition(String stmPosition) {
        this.stmPosition = stmPosition;
    }

    public String getStmUsername() {
        return stmUsername;
    }

    public void setStmUsername(String stmUsername) {
        this.stmUsername = stmUsername;
    }

    public String getStmPassword() {
        return stmPassword;
    }

    public void setStmPassword(String stmPassword) {
        this.stmPassword = stmPassword;
    }

    public Advertisement getAdid() {
        return adid;
    }

    public void setAdid(Advertisement adid) {
        this.adid = adid;
    }
    
     public String getStmSecquesans() {
        return stmSecquesans;
    }

    public void setStmSecquesans(String stmSecquesans) {
        this.stmSecquesans = stmSecquesans;
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
        if (!(object instanceof StaffAndManagement)) {
            return false;
        }
        StaffAndManagement other = (StaffAndManagement) object;
        return !((this.stmid == null && other.stmid != null) || (this.stmid != null && !this.stmid.equals(other.stmid)));
    }

    @Override
    public String toString() {
        return "Database.StaffAndManagement[ stmid=" + stmid +  adid+" ]";
    }

    public NurseInCharge getNurseInCharge() {
        return nurseInCharge;
    }

    public void setNurseInCharge(NurseInCharge nurseInCharge) {
        this.nurseInCharge = nurseInCharge;
    }

   
    
}
