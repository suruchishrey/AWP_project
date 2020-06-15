/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;

import datapack.Admin;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;

/**
 *
 * @author kumar
 */
public class Adminservices {
   
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
    
   public boolean login(String name , String password)
   {
     try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM admins;";
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Admin ad = new Admin();
                       
                       ad.setname(rs.getString(2));
                       ad.setpassword(rs.getString(3));
                       
                       if(ad.getname().equals(name) && ad.getpassword().equals(password))
                       {
                           
                           return true;
                       }
                       
                       
                       
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return false;
           
       
   }
    
    
    
}
