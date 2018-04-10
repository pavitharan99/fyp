/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author MSI-PC
 */
import Database.Advertisement;
import java.sql.*;
import javax.swing.*;

public class advertisment {
    private String host = "jdbc:derby://localhost:1527/FYP";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Advertisement";
    private Connection conn;
    private PreparedStatement stmt;
    
    public advertisment(){
        createConnection();
        
    }

public Advertisement getRecord(String Adid) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Adid = ?";
        Advertisement ad = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, Adid);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                ad = new Advertisement(Adid, rs.getString("AD_name"), rs.getDate("AD_Date"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return ad;
    }

 public void addRecord(Advertisement advertisement) {
       String insertStr = "INSERT INTO " + tableName + " VALUES(?, ?, ?)";
        try {
              
               stmt=conn.prepareStatement(insertStr);
               stmt.setString(1,advertisement.getAdid() );
               stmt.setString(2,advertisement.getAdName() );
               stmt.setDate(3, (Date) advertisement.getAdDate());
           
               stmt.executeUpdate();
              
     
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }


  public void updateRecord(Advertisement advertisement) {
       String updateStr = "UPDATE " + tableName + "  SET AD_Name = ?,  AD_Date = ? WHERE ADID =?" ;
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
               stmt=conn.prepareStatement(updateStr);
               stmt.setString(1,advertisement.getAdid() );
               stmt.setString(2,advertisement.getAdName() );
               stmt.setDate(3, (Date) advertisement.getAdDate());
           
      
               stmt.executeUpdate();
              
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

  public void deleteRecord(Advertisement advertisement) {
       String deleteStr = "DELETE FROM " + tableName + " WHERE ADID = ?";
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
               stmt=conn.prepareStatement(deleteStr);
               
              stmt.setString(1,advertisement.getAdid() );

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
            advertisment  da = new advertisment ();
            Advertisement  advertisment  = da.getRecord("AD00001");
            System.out.println(advertisment);
    }

}

