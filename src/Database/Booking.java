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
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByBookingid", query = "SELECT b FROM Booking b WHERE b.bookingid = :bookingid")
    , @NamedQuery(name = "Booking.findByBooingDate", query = "SELECT b FROM Booking b WHERE b.booingDate = :booingDate")
    , @NamedQuery(name = "Booking.findByBookingTime", query = "SELECT b FROM Booking b WHERE b.bookingTime = :bookingTime")
    , @NamedQuery(name = "Booking.findByStmid", query = "SELECT b FROM Booking b WHERE b.stmid = :stmid")
    , @NamedQuery(name = "Booking.findByBookingstatus", query = "SELECT b FROM Booking b WHERE b.bookingstatus = :bookingstatus")})
public class Booking implements Serializable {

    @JoinColumn(name = "STMID", referencedColumnName = "STMID")
    @ManyToOne
    private NurseInCharge stmid;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BOOKINGID")
    private String bookingid;
    @Column(name = "BOOING_DATE")
    @Temporal(TemporalType.DATE)
    private Date booingDate;
    @Column(name = "BOOKING_TIME")
    @Temporal(TemporalType.TIME)
    private Date bookingTime;
    @Column(name = "STMID")
    private String stmid;
    @Column(name = "BOOKINGSTATUS")
    private String bookingstatus;
    @JoinColumn(name = "DONORID", referencedColumnName = "DONORID")
    @ManyToOne
    private Donor donorid;

    public Booking() {
    }

    public Booking(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public Date getBooingDate() {
        return booingDate;
    }

    public void setBooingDate(Date booingDate) {
        this.booingDate = booingDate;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStmid() {
        return stmid;
    }

    public void setStmid(String stmid) {
        this.stmid = stmid;
    }

    public String getBookingstatus() {
        return bookingstatus;
    }

    public void setBookingstatus(String bookingstatus) {
        this.bookingstatus = bookingstatus;
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
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Booking[ bookingid=" + bookingid + " ]";
    }

    public NurseInCharge getStmid() {
        return stmid;
    }

    public void setStmid(NurseInCharge stmid) {
        this.stmid = stmid;
    }
    
}
