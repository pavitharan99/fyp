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
import Database.Schedule;
import java.sql.*;
import javax.swing.*;

public class schedule {
    private String host = "jdbc:derby://localhost:1527/FYP";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Schedule";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQueryStr = "SELECT * FROM " + tableName;  
    
    public schedule(){
       createConnection();
    }
    public Schedule getRecord(String SchID){
       String queryStr = "SELECT * FROM " + tableName + " WHERE SCHID = ?";
       Schedule sch=null;
      try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, SchID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                sch = new Schedule(SchID, rs.getTime("SCH_time"));           
            }
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return sch;
    }
     public void addRecord(Schedule sch) {
       String insertStr = "INSERT INTO " + tableName + " VALUES(?,?)";
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
             stmt = conn.prepareStatement(insertStr);
             
             stmt.setString(1, sch.getSchid());
             stmt.setTime(2, (Time) sch.getSchTime());
 
             
             
             stmt.executeUpdate();
              
             
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateRecord(Schedule sch){
        String updateStr = "UPDATE " + tableName + " SET sch_time = ?,  WHERE Schid = ?";
        try{
            stmt = conn.prepareStatement(updateStr);
             stmt.setString(1, sch.getSchid());
             stmt.setTime(2, (Time) sch.getSchTime());
 
    
            
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteRecord(Schedule sch){
        String deleteStr = "DELETE FROM " + tableName + " WHERE Schid = ?";
        try{
            stmt = conn.prepareStatement(deleteStr);
            stmt.setString(1, sch.getSchid());
        
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
        schedule dr = new schedule();
        Schedule donor = dr.getRecord("SCH00001");
        System.out.println(donor);
    }
} 
