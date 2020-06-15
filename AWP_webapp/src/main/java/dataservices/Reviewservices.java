/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import datapack.Reviews;
/**
 *
 * @author kumar
 */
public class Reviewservices {
    
      
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
     public ArrayList<Reviews> getAllReviews()
    {
         ArrayList<Reviews> reviewlist = new ArrayList<Reviews>();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM reviews ORDER BY id DESC;";
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                        Reviews re = new Reviews();
                        
                        re.setId(Integer.parseInt(rs.getString(1)));
                        re.setName(rs.getString(2));
                        re.setComment(rs.getString(3));
                        re.setRating(rs.getString(4));
                        
                        reviewlist.add(re);
                    }
               
                }
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return reviewlist;
        
    }
    
    
    public boolean RegisterReview(Reviews re)
    { 
        try
        {
            
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "insert into reviews(name, comment, rating) values (?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(query);
           
          
            pstmt.setString(1,re.getName());
            pstmt.setString(2,re.getComment());
            pstmt.setString(3,re.getRating());
                    
            pstmt.executeUpdate();
            
            return true;
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            
        }
        
        return false;
        
    }     
    
    
    
}
