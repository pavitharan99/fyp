/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import Database.*;
import domain.*;
import java.sql.*;
import javax.swing.*;

public class booking {
    private String host = "jdbc:derby://localhost:1527/collegedb";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Programmes";
    private Connection conn;
    private PreparedStatement stmt;
    
    public booking() {
        createConnection();
    }

     public Booking getRecord(String bookingid) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Code = ?";
        Booking booking = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, bookingid);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                booking = new Booking(bookingid, rs.getString("bookingid"), rs.getDate("bookingDate"), rs.getTime("bookingTime"), rs.getString("Donorid"), rs.getString("bookingStatus"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return booking;
    }
    
    
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
