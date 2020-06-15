/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;
import datapack.Packages;
import datapack.Professionals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kumar
 */
public class Packageservices {
    
    
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
   
    
    public ArrayList<Packages> getAllPackages()
    {
             ArrayList<Packages> packlist = new ArrayList<Packages>();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM packages;";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Packages pack = new Packages();

                       pack.setId(Integer.parseInt(rs.getString(1)));
                       pack.setName(rs.getString(2));
                       pack.setImage_url(rs.getString(3));
                       
                       packlist.add(pack);
                      
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return packlist;
            
    
    
    }
    
    
    
}
