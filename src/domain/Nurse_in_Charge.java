/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.schedule;
import domain.Staff_and_Mnagement;
import Database.*;
import java.sql.*;
import javax.swing.*;

public class Nurse_in_Charge{
    private schedule sch;
    private Staff_and_Mnagement stm;
    private String host = "jdbc:derby://localhost:1527/FYP";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "NurseInCharge";
    private Connection conn;
    private PreparedStatement stmt;
    
    public Nurse_in_Charge() {
        createConnection();
        sch=new schedule();
        stm= new Staff_and_Mnagement();
    }

public StaffAndManagement getRecord(String stmid) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Stmid = ?";
        NurseInCharge nic = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, stmid);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                StaffAndManagement Stm=stm.getRecord(rs.getString("Stmid"));
                Schedule Sch = sch.getRecord(rs.getString("Schid"));
                nic = new NurseInCharge(Stm, rs.getString("stm_Name"), rs.getString("stm_Nric"),rs.getString("stm_Contactnum"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff_and_mnagament;
    }

 public void addRecord(StaffAndManagement staff_and_management) {
       String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?, ? ,? ,?, ?, ?, ?, ?, ?, ?)";
        try {
              
               stmt=conn.prepareStatement(insertStr);
               stmt.setString(1, staff_and_management.getStmid());
               stmt.setString(2, staff_and_management.getStmName());
               stmt.setString(3, staff_and_management.getStmNric());
               stmt.setString(4, staff_and_management.getStmContactnum());
               stmt.setString(5, staff_and_management.getStmAddress());
               stmt.setString(6, staff_and_management.getStmEmail());
               stmt.setString(7, staff_and_management.getStmPosition());
               stmt.setString(8, staff_and_management.getStmEmail());
               stmt.setString(9, staff_and_management.getStmPosition());
               stmt.setString(10, staff_and_management.getStmUsername());
               stmt.setString(11, staff_and_management.getStmPassword());
               stmt.setString(12, staff_and_management.getStmSecquesans());
               stmt.executeUpdate();
              
     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


  public void updateRecord(StaffAndManagement staff_and_mnagement) {
       String updateStr = "UPDATE " + tableName + "  SET Stm_Name = ?,  Stm_Nric = ?, Stm_Contactnum = ?, Stm_Address = ?, Stm_Email = ?, Stm_Position = ?, Stm_Username = ? WHERE Stmid =?" ;
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
               stmt=conn.prepareStatement(updateStr);
               stmt.setString(1, staff_and_mnagement.getStmName());
               stmt.setString(2, staff_and_mnagement.getStmNric());
               stmt.setString(3, staff_and_mnagement.getStmContactnum());
               stmt.setString(4, staff_and_mnagement.getStmAddress());
               stmt.setString(5, staff_and_mnagement.getStmEmail());
               stmt.setString(6, staff_and_mnagement.getStmPosition());
               stmt.setString(7, staff_and_mnagement.getStmUsername());
               stmt.executeUpdate();
              
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

  public void deleteRecord(StaffAndManagement staff_and_mnagament) {
       String deleteStr = "DELETE FROM " + tableName + " WHERE Stmid = ?";
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
               stmt=conn.prepareStatement(deleteStr);
               
               stmt.setString(1,staff_and_mnagament.getStmid());

               stmt.executeUpdate();
              
          
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
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
            Staff_and_Mnagement  da = new Staff_and_Mnagement ();
            StaffAndManagement   advertisment  = da.getRecord("STM00003");
            System.out.println(advertisment);
    }

}

