/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;

import datapack.Allotmentqueue;
import datapack.Professionals;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;


/**
 *
 * @author kumar
 */
public class Professionalservices {
      
    
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
    ArrayList<Professionals> proflist  = new ArrayList<Professionals>();
     
    
    public  ArrayList<Professionals> getProfessionalsList()
    {
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM professionals where register='true';";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       Professionals prof = new Professionals();

                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setpassword(rs.getString(4));
                       prof.setprofession(rs.getString(5));
                       prof.setemail(rs.getString(6));
                       prof.setmob_no(rs.getString(7));
                       prof.setaddress(rs.getString(8));
                       prof.setgender(rs.getString(9));
                       prof.setstatus(rs.getString(10));
                       prof.setrating(rs.getString(11));
                       prof.setsalary(rs.getString(12));
                       prof.settotal_services(rs.getString(13));

                       proflist.add(prof);

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return proflist;
            
        
    }
    
    
    public Professionals getProfessinalsById(String id)
    {   
         Professionals prof = new Professionals();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM professionals WHERE id="+id;

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      

                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setusername(rs.getString(3));
                       prof.setpassword(rs.getString(4));
                       prof.setprofession(rs.getString(5));
                       prof.setemail(rs.getString(6));
                       prof.setmob_no(rs.getString(7));
                       prof.setaddress(rs.getString(8));
                       prof.setgender(rs.getString(9));
                       prof.setstatus(rs.getString(10));
                       prof.setrating(rs.getString(11));
                       prof.setsalary(rs.getString(12));
                       prof.settotal_services(rs.getString(13));
                       prof.setregister(rs.getString(14));
                       prof.setservice_id(Integer.parseInt(rs.getString(15)));
                       

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return prof;
        
        
        
    }
    
    
      public  ArrayList<Professionals> getProfessinalsByProfession(String id)
    {   
          ArrayList<Professionals> proflist  = new ArrayList<Professionals>();
        
         try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM professionals WHERE register='true' AND service_id=+"+"'"+id+"'"+";";

            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                      Professionals prof = new Professionals();

                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setpassword(rs.getString(4));
                       prof.setprofession(rs.getString(5));
                       prof.setemail(rs.getString(6));
                       prof.setmob_no(rs.getString(7));
                       prof.setaddress(rs.getString(8));
                       prof.setgender(rs.getString(9));
                       prof.setstatus(rs.getString(10));
                       prof.setrating(rs.getString(11));
                       prof.setsalary(rs.getString(12));
                       prof.settotal_services(rs.getString(13));
                       prof.setregister(rs.getString(14));
                       prof.setservice_id(Integer.parseInt(rs.getString(15)));
                       proflist.add(prof);

                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return proflist;
        
        
        
    }
    
    public Professionals login(String name,String password)
    {
        Professionals prof=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                //String sql = "SELECT * FROM professionals;";
            String sql = "SELECT * FROM professionals WHERE username = ? AND password = ? AND register='true'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            prof = null;
            if (result.next()) {
                prof = new Professionals();
                prof.setname(result.getString("name"));
                prof.setpassword(result.getString("password"));
                prof.setid(Integer.parseInt(result.getString("id")));
            }
        }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return prof;
    }
 
    public boolean UpdateDetails(Professionals prof)
    {
        boolean retval=false;
         String id;
         id = Integer.toString(prof.getid());
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
            PreparedStatement ps;
                    String sql="Update professionals set id=?,name=?,username=?,password=?,profession=?,email=?,mob_no=?,address=?,gender=?,status=? where id="+id;
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,id);
                    ps.setString(2,prof.getname());
                    ps.setString(3,prof.getusername());
                    ps.setString(4,prof.getpassword());
                    ps.setString(5,prof.getprofession());
                    ps.setString(6, prof.getemail());
                    ps.setString(7, prof.getmob_no());
                    ps.setString(8, prof.getaddress());
                    ps.setString(9, prof.getgender());
                    ps.setString(10, prof.getstatus());
                    int i = ps.executeUpdate();
                    if(i>0)
                    {
                        retval=true;
                    }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return retval;
    }
    public boolean updateProfStats(String id,String salary,String num_services)
    {
        boolean retval=false;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
            PreparedStatement ps;
                    String sql="Update professionals set status=?,salary=?,total_services=? where id="+id;
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,"busy");
                    ps.setString(2,salary);
                    ps.setString(3,num_services);
                    ps.executeUpdate();
                    
                    retval = true;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return retval;           
    }
    
    public boolean updateProfRating(String id,String rating)
    {
       boolean retval=false;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
            PreparedStatement ps;
                    String sql="Update professionals set rating=? where id="+id;
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,rating);
                    ps.executeUpdate();
                    
                    retval = true;
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return retval;           
    }
    public String changeAvailability(int id)
    {
        String currentstatus,status="free";
        try{
                Class.forName("com.mysql.jdbc.Driver");
            
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                PreparedStatement ps;
             
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT status FROM professionals WHERE id="+Integer.toString(id));
                if(rs.next())
                {
                    currentstatus=rs.getString(1);
                
                    if(currentstatus.equals("free"))
                    {
                        status="busy";
                    }
                    else if(currentstatus.equals("busy"))
                    {
                        status="free";
                    }
                }
                String sql="UPDATE professionals set status='"+status+"' WHERE id="+Integer.toString(id);
                ps = conn.prepareStatement(sql);  
                int i = ps.executeUpdate();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return status;
    }

    public Professionals getProfessionalsByName(String name)
    {
        Professionals prof = new Professionals();
           try{
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);
                String sql = "SELECT * FROM professionals WHERE username='"+name+"'";
            
            
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
               
                    while(rs.next())
                    {   
                       

                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setpassword(rs.getString(4));
                       prof.setprofession(rs.getString(5));
                       prof.setemail(rs.getString(6));
                       prof.setmob_no(rs.getString(7));
                       prof.setaddress(rs.getString(8));
                       prof.setgender(rs.getString(9));
                       prof.setstatus(rs.getString(10));
                       prof.setrating(rs.getString(11));
                       prof.setsalary(rs.getString(12));
                       prof.settotal_services(rs.getString(13));
                       prof.setregister(rs.getString(14));
                       prof.setservice_id(Integer.parseInt(rs.getString(15)));
                    }
                
               
                }
           
                catch(Exception e)
                {
                    System.out.println("failure in connection");
                }
           
           return prof;
            
        
    }

    
}
