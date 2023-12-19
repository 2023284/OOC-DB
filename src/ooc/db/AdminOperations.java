/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import assignment.db.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author danyal
 */
public class AdminOperations {
    
    Connection connection = null;
    public int modifyProfile(String name, String surname) throws SQLException
    {
        connection =  DBManager.getConnection();
        
        String query   =  "update users set name= '"+name+"', surname='"+surname+"' where role = 'Admin' ";
        PreparedStatement stat = connection.prepareStatement(query);
        int result = stat.executeUpdate();
        return result;
        
         
    }
    
    public int removeUser(String username) throws SQLException
    {
         connection = DBManager.getConnection();
         String deleteQuery = "delete from users where username = '"+username+"'";
         PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
         
         return pstmt.executeUpdate();
         
    }
    
    
}
