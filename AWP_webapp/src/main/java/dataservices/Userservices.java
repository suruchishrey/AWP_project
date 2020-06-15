/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;
import datapack.Professionals;
import datapack.Users;
import java.util.*;
import java.sql.*;

/**
 *
 * @author kumar
 */
public class Userservices {
    
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
     ArrayList<Users> userlist  = new ArrayList<Users>();
     
    
    public  ArrayList<Users> getUsersList()
    {
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM users;";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Users user = new Users();

                       user.setid(Integer.parseInt(rs.getString(1)));
                       user.setname(rs.getString(2));
                       user.setpassword(rs.getString(3));
                       user.setemail(rs.getString(4));
                       user.setmob_no(rs.getString(5));
                       user.setaddress(rs.getString(6));
                       user.setgender(rs.getString(7));
                       user.setImage_url(rs.getString(8));
                       
                       userlist.add(user);

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return userlist;
            
        
    }
    
    public Users getUsersByName(String name)
    {
        Users user = new Users();
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM users WHERE name='"+name+"'";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       

                       user.setid(Integer.parseInt(rs.getString(1)));
                       user.setname(rs.getString(2));
                       user.setpassword(rs.getString(3));
                       user.setemail(rs.getString(4));
                       user.setmob_no(rs.getString(5));
                       user.setaddress(rs.getString(6));
                       user.setgender(rs.getString(7));
                       user.setImage_url(rs.getString(8));
                       
                      

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return user;
            
        
    }
    public String register_user(Users user)
    { 
      
        String ret="";
        try
        {
            
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "insert into users(name, password, email, mob_no, address, gender) values (?,?,?,?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1,user.getname());
            pstmt.setString(2,user.getpassword());
            pstmt.setString(3,user.getemail());
            pstmt.setString(4,user.getmob_no());
            pstmt.setString(5,user.getaddress());
            pstmt.setString(6,user.getgender());
         
            
            

            pstmt.executeUpdate();
            ret="true";
            return ret;
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            ret=e.getMessage();
        }
        
        return ret;
        
    }     
    
    
     public boolean login(String name , String password)
   {
     try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM users;";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Users ad = new Users();
                       
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
    
    public Users getUsersById(String id)
    {
        Users user = new Users();
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM users WHERE id="+id;
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       

                       user.setid(Integer.parseInt(rs.getString(1)));
                       user.setname(rs.getString(2));
                       user.setpassword(rs.getString(3));
                       user.setemail(rs.getString(4));
                       user.setmob_no(rs.getString(5));
                       user.setaddress(rs.getString(6));
                       user.setgender(rs.getString(7));
                       user.setImage_url(rs.getString(8));
                       
                      

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return user;
            
        
    }
    
   
    
}
