/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;
import datapack.Packages;
import datapack.Services;
import datapack.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kumar
 */
public class Serviceservices {
   
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
   
    public ArrayList<Services> getServicesByPackageId(String id)
    {
        
        
         ArrayList<Services> servicelist = new ArrayList<Services>();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                 String sql = "SELECT * FROM services WHERE package_id="+id;

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      
                        Services serv = new Services();
                        
                        serv.setId(Integer.parseInt(rs.getString(1)));
                        serv.setName(rs.getString(2));
                        serv.setPrice(Integer.parseInt(rs.getString(3)));
                        serv.setDescription(rs.getString(4));
                        serv.setImage_url(rs.getString(5));
                        serv.setPackage_id(Integer.parseInt(rs.getString(6)));
                        
                        servicelist.add(serv);
                        
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return servicelist;
        
    }
    
    
    
    
    
     public Services getServicesByServiceId(String id)
    {   
        
           
        
                        Services serv = new Services();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                 String sql = "SELECT * FROM services WHERE id="+id;

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      
                        
                        serv.setId(Integer.parseInt(rs.getString(1)));
                        serv.setName(rs.getString(2));
                        serv.setPrice(Integer.parseInt(rs.getString(3)));
                        serv.setDescription(rs.getString(4));
                        serv.setImage_url(rs.getString(5));
                        serv.setPackage_id(Integer.parseInt(rs.getString(6)));
                        
                           
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return serv;
        
    }
     
     
     
      public boolean register_service(Services serv)
    { 
      
        
        try
        {
            
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "insert into services(name, price, description, image_url, package_id) values (?,?,?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(query);
           
          
            pstmt.setString(1,serv.getName());
            pstmt.setString(2,Integer.toString(serv.getPrice()));
            pstmt.setString(3,serv.getDescription());
            pstmt.setString(4,serv.getImage_url());
            pstmt.setString(5,Integer.toString(serv.getPackage_id()));
           
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