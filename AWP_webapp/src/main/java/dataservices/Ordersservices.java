/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataservices;


import datapack.Orders;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Ordersservices {
    private final String dbuser = "root";
    private final String dbpass = "Suruchi@2001";
    
    
  
  public void push(Orders order)
  {
      
      try
        {
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "insert into orders values (?,?,?);";

            PreparedStatement pstmt = conn.prepareStatement(query);
           
            pstmt.setString(1,Integer.toString(order.getProfessional_id()));
            pstmt.setString(2,Integer.toString(order.getService_id()));
            pstmt.setString(3,Integer.toString(order.getUser_id()));
         
            
            
            pstmt.executeUpdate();
            
           
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            
        }
  }
  
    public ArrayList<Orders> getOrdersList()
    {
        ArrayList<Orders>OrdersList=new ArrayList<Orders>();
       try
        {
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "SELECT * FROM orders";

            Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(query);
               
                    while(rs.next())
                    { 
                        Orders order=new Orders();
                        order.setProfessional_id(Integer.parseInt(rs.getString("professional_id")));
                        order.setUser_id(Integer.parseInt(rs.getString("user_id")));
                        order.setService_id(Integer.parseInt(rs.getString("service_id")));
                        
                        OrdersList.add(order);
                    }
            
           
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            
        }
       return OrdersList;
    }
  
    public ArrayList<Orders> getOrdersByUserId(int id)
    {
        ArrayList<Orders>OrdersList=new ArrayList<Orders>();
       try
        {
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "SELECT * FROM orders WHERE user_id="+Integer.toString(id);

            Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(query);
               
                    while(rs.next())
                    { 
                        Orders order=new Orders();
                        order.setUser_id(id);
                        order.setProfessional_id(Integer.parseInt(rs.getString("professional_id")));
                        order.setService_id(Integer.parseInt(rs.getString("service_id")));
                        
                        OrdersList.add(order);
                        
                    }
            
           
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            
        }
       return OrdersList;
    }
      
    public ArrayList<Orders> getOrdersByProfId(int id)
    {
        ArrayList<Orders>OrdersList=new ArrayList<Orders>();
       try
        {
              
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv",dbuser,dbpass);


            String query = "SELECT * FROM orders WHERE professional_id="+Integer.toString(id);

            Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(query);
               
                    while(rs.next())
                    { 
                        Orders order=new Orders();
                        order.setProfessional_id(id);
                        order.setUser_id(Integer.parseInt(rs.getString("user_id")));
                        order.setService_id(Integer.parseInt(rs.getString("service_id")));
                        
                        OrdersList.add(order);
                    }
            
           
            
        } 
        catch(Exception e)
        {
            System.out.println("Error");
            
        }
       return OrdersList;
    }
  
  
}
