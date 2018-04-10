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
@Table(name = "DONOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donor.findAll", query = "SELECT d FROM Donor d")
    , @NamedQuery(name = "Donor.findByDonorid", query = "SELECT d FROM Donor d WHERE d.donorid = :donorid")
    , @NamedQuery(name = "Donor.findByDonorName", query = "SELECT d FROM Donor d WHERE d.donorName = :donorName")
    , @NamedQuery(name = "Donor.findByDonorAge", query = "SELECT d FROM Donor d WHERE d.donorAge = :donorAge")
    , @NamedQuery(name = "Donor.findByDonorAddress", query = "SELECT d FROM Donor d WHERE d.donorAddress = :donorAddress")
    , @NamedQuery(name = "Donor.findByDonorEmail", query = "SELECT d FROM Donor d WHERE d.donorEmail = :donorEmail")
    , @NamedQuery(name = "Donor.findByDonorBloodGroup", query = "SELECT d FROM Donor d WHERE d.donorBloodGroup = :donorBloodGroup")
    , @NamedQuery(name = "Donor.findByDonorUsername", query = "SELECT d FROM Donor d WHERE d.donorUsername = :donorUsername")
    , @NamedQuery(name = "Donor.findByDonorPassword", query = "SELECT d FROM Donor d WHERE d.donorPassword = :donorPassword")
    , @NamedQuery(name = "Donor.findByDonorSecquesans", query = "SELECT d FROM Donor d WHERE d.donorSecquesans = :donorSecquesans")
    , @NamedQuery(name = "Donor.findByDonorNric", query = "SELECT d FROM Donor d WHERE d.donorNric = :donorNric")
    , @NamedQuery(name = "Donor.findByDonorContactnum", query = "SELECT d FROM Donor d WHERE d.donorContactnum = :donorContactnum")})
public class Donor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DONORID")
    private String donorid;
    @Column(name = "DONOR_NAME")
    private String donorName;
    @Column(name = "DONOR_AGE")
    private Integer donorAge;
    @Column(name = "DONOR_ADDRESS")
    private String donorAddress;
    @Column(name = "DONOR_EMAIL")
    private String donorEmail;
    @Column(name = "DONOR_BLOOD_GROUP")
    private String donorBloodGroup;
    @Column(name = "DONOR_USERNAME")
    private String donorUsername;
    @Column(name = "DONOR_PASSWORD")
    private String donorPassword;
    @Column(name = "DONOR_SECQUESANS")
    private String donorSecquesans;
    @Column(name = "DONOR_NRIC")
    private String donorNric;
    @Column(name = "DONOR_CONTACTNUM")
    private String donorContactnum;
    @OneToMany(mappedBy = "donorid")
    private List<BloodDonation> bloodDonationList;
    @OneToMany(mappedBy = "donorid")
    private List<Booking> bookingList;

    public Donor() {
    }

    public Donor(String donorid) {
        this.donorid = donorid;
    }
    
public Donor(String Donorid,String Donor_name,int Donor_age,String Donor_Address,String Donor_Email,String Donor_Blood_Group,String Donor_username,String Donor_password,String Donor_Secquesans,String Donor_NRIC,String Donor_contact){
         this.donorid=Donorid;
         this.donorName=Donor_name;
         this.donorAge=Donor_age;
         this.donorAddress=Donor_Address;
         this.donorEmail=Donor_Email;
         this.donorBloodGroup=Donor_Blood_Group;
         this.donorUsername=Donor_username;
         this.donorPassword=Donor_password;
         this.donorSecquesans=Donor_Secquesans;
         this.donorNric=Donor_NRIC;
         this.donorContactnum=Donor_contact;
    }

    public String getDonorid() {
        return donorid;
    }

    public void setDonorid(String donorid) {
        this.donorid = donorid;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Integer getDonorAge() {
        return donorAge;
    }

    public void setDonorAge(Integer donorAge) {
        this.donorAge = donorAge;
    }

    public String getDonorAddress() {
        return donorAddress;
    }

    public void setDonorAddress(String donorAddress) {
        this.donorAddress = donorAddress;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorBloodGroup() {
        return donorBloodGroup;
    }

    public void setDonorBloodGroup(String donorBloodGroup) {
        this.donorBloodGroup = donorBloodGroup;
    }

    public String getDonorUsername() {
        return donorUsername;
    }

    public void setDonorUsername(String donorUsername) {
        this.donorUsername = donorUsername;
    }

    public String getDonorPassword() {
        return donorPassword;
    }

    public void setDonorPassword(String donorPassword) {
        this.donorPassword = donorPassword;
    }

    public String getDonorSecquesans() {
        return donorSecquesans;
    }

    public void setDonorSecquesans(String donorSecquesans) {
        this.donorSecquesans = donorSecquesans;
    }

    public String getDonorNric() {
        return donorNric;
    }

    public void setDonorNric(String donorNric) {
        this.donorNric = donorNric;
    }

    public String getDonorContactnum() {
        return donorContactnum;
    }

    public void setDonorContactnum(String donorContactnum) {
        this.donorContactnum = donorContactnum;
    }

    @XmlTransient
    public List<BloodDonation> getBloodDonationList() {
        return bloodDonationList;
    }

    public void setBloodDonationList(List<BloodDonation> bloodDonationList) {
        this.bloodDonationList = bloodDonationList;
    }

    @XmlTransient
    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donorid != null ? donorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.donorid == null && other.donorid != null) || (this.donorid != null && !this.donorid.equals(other.donorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Donor[ donorid=" + donorid + " ]";
    }
    
}
