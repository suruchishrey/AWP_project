/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;

import datapack.Allotmentqueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kumar
 */
public class Allotmentqueueservices {
    
    
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
    
    public Allotmentqueue getTopProfessinal(String id)
    {   
        
        
             Allotmentqueue aq = new Allotmentqueue();
             
             int flag = 0;
           
         
         try{
            
             
                
             
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                 String sql = "SELECT * FROM allotmentqueue WHERE service_id="+id;

                
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
              
                      while(rs.next())
                      {   
                        
                        aq.setProfessional_id(Integer.parseInt(rs.getString(1)));
                        aq.setService_id(Integer.parseInt(rs.getString(2)));
                        
                        flag = 1;
                       
                        break;
                        
                      }
                      
                   
            
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
         
       
          return aq;  
        
     
    }
    
    
  public void pop(Allotmentqueue aq)
  {
      try{
            
             
                String id = Integer.toString(aq.getProfessional_id());
             
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                 String sql = "Delete FROM allotmentqueue WHERE professional_id="+id;
                Statement pstmt = conn.createStatement();
                pstmt.executeUpdate(sql);
            
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
         
  
  
  }
  
  
  public void push(Allotmentqueue aq)
  {
      
      try
        {
            
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "insert into allotmentqueue values (?,?);";

            PreparedStatement pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1,Integer.toString(aq.getProfessional_id()));
            pstmt.setString(2,Integer.toString(aq.getService_id()));
          
         
            
            
            pstmt.executeUpdate();
            
           
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            
        }
        
       
      
  
  }
  
    
    
    
    
    
    
    
    
    
    
}
