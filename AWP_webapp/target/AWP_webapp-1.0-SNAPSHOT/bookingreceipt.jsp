<%-- 
    Document   : bookingreceipt
    Created on : 21-Apr-2020, 5:26:51 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="datapack.*" %>
<%@page import="java.util.*"%>

<jsp:include page="header.jsp"/>
<%   Services s = (Services) request.getAttribute("serv") ; %>
<%   Professionals p = (Professionals) request.getAttribute("prof") ; %>


<style>
    
    #container{
        
        border: 3px solid gray;
        border-radius: 5px;
    
           
    }
    
</style>    

<div class="container my-3 p-3" id="container">
    
     <%if(p.getname() != null){%>   
    
    <div class="alert alert-success" style="text-align: center">
        <h1>Booking Successful</h1>
    </div>    
    
    
      
    <div class="row">
        
        <div class="col-sm-6">
            
            <h5>Your Booking details</h5>
            <p>Service Name:<%=s.getName()%></p>
            <p>Service Cost: Rs.<%=s.getPrice()%></p>
            <p>Service Description:<%=s.getDescription()%></p>
              
             
        </div> 
            
            
      
        
        <div class="col-sm-6">
            
            <h5>Details of Professional</h5>
            <p> Name:<%=p.getname()%></p>
            <p>Mob no. :<%=p.getmob_no()%></p>
            <p>Email:<%=p.getemail()%></p>
              
             
        </div>
            
    </div>
            
    <div class="alert alert-info" style="text-align: center">
        <h1>Thank You !! Visit Again</h1>
    </div>  
    
     <a class="btn btn-primary" href="writereview.jsp">Feedback</a>
      
</div>
    
      <%}else{%>   
       
        
    <div class="alert alert-danger" style="text-align: center">
        <h1>Booking Unsuccessful</h1>
    </div>  

      <p>Sorry !! none of our Professionals are free currently</p>
      
      <a class="btn btn-primary" href="/AWP_webapp/userservicesservlet?value=<%=s.getPackage_id()%>">Back to Home</a>
      
       <%}%> 
    
</div>    