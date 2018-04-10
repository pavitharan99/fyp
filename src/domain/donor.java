/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author zxchia
 */
import Database.Donor;
import java.sql.*;
import javax.swing.*;

public class donor {
    private String host = "jdbc:derby://localhost:1527/FYP";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Donor";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;  
    
    public donor(){
       createConnection();
    }
    public Donor getRecord(String donorID){
       String queryStr = "SELECT * FROM " + tableName + " WHERE DonorID = ?";
       Donor dnr=null;
      try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, donorID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dnr = new Donor(donorID, rs.getString("Donor_Name"), rs.getInt("Donor_Age"),rs.getString("Donor_Address"),rs.getString("Donor_Email"),rs.getString("Donor_Blood_Group"),rs.getString("Donor_username"),rs.getString("Donor_password"),rs.getString("Donor_Secquesans"),rs.getString("Donor_Nric"),rs.getString("Donor_Contactnum"));            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return dnr;
    }
     public void addRecord(Donor donor) {
       String insertStr = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
             stmt = conn.prepareStatement(insertStr);
             
             stmt.setString(1, donor.getDonorid());
             stmt.setString(2, donor.getDonorName());
             stmt.setInt(3,donor.getDonorAge());
             stmt.setString(4, donor.getDonorAddress());
             stmt.setString(5, donor.getDonorEmail());
             stmt.setString(6, donor.getDonorBloodGroup());
             stmt.setString(7, donor.getDonorUsername());
             stmt.setString(8, donor.getDonorPassword());
             stmt.setString(9, donor.getDonorSecquesans());
             stmt.setString(10, donor.getDonorNric());
             stmt.setString(11, donor.getDonorContactnum());
             
             
             stmt.executeUpdate();
              
             
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateRecord(Donor donor){
        String updateStr = "UPDATE " + tableName + " SET Donor_Name = ?, Donor_Age = ? , Donor_Address= ? , Donor_Email= ? , Donor_Blood_Group= ? , Donor_username= ? , Donor_password = ? , Donor_Secquesans=? , Donor_Nric=? , Donor_Contactnum= ?  WHERE DonorID = ?";
        try{
            stmt = conn.prepareStatement(updateStr);
             stmt.setString(1, donor.getDonorid());
             stmt.setString(2, donor.getDonorName());
             stmt.setInt(3,donor.getDonorAge());
             stmt.setString(4, donor.getDonorAddress());
             stmt.setString(5, donor.getDonorEmail());
             stmt.setString(6, donor.getDonorBloodGroup());
             stmt.setString(7, donor.getDonorUsername());
             stmt.setString(8, donor.getDonorPassword());
             stmt.setString(9, donor.getDonorSecquesans());
             stmt.setString(10, donor.getDonorNric());
             stmt.setString(11, donor.getDonorContactnum());
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteRecord(Donor donor){
        String deleteStr = "DELETE FROM " + tableName + " WHERE DonorID = ?";
        try{
            stmt = conn.prepareStatement(deleteStr);
            stmt.setString(1, donor.getDonorid());
        
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        donor dr = new donor();
        Donor donor = dr.getRecord("DNR00001");
        System.out.println(donor);
    }
} 

