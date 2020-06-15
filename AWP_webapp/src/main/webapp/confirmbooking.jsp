<%-- 
    Document   : confirmbooking
    Created on : 21-Apr-2020, 1:04:11 AM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="datapack.Services" %>
<%@page import="java.util.*"%>

<jsp:include page="header.jsp"/>
<%   Services s = (Services) request.getAttribute("serv") ; %>


<style>
    
    #container{
        
        border: 3px solid gray;
        border-radius: 5px;
    
           
    }
    
</style>    



<div class="container my-3 p-3 " id="container">
    
    
    
   
        
        <div class="alert alert-primary" style="text-align:center">
            <h3>Confirm Your Booking</h3>  
        </div>    
        
  
    
     
    <div class="row">
        
        <div class="col-sm-6">
            
            <h5>Your Booking details</h5>
            <p>Service Name:<%=s.getName()%></p>
            <p>Service Cost: Rs.<%=s.getPrice()%></p>
            <p>Service Description:<%=s.getDescription()%></p>
              
             
        </div>    
        
        <div class="col-sm-6">
             
        </div>    
        
    </div>
    
    
    
    
    


    <div class="row">
    
        <div class="col-sm-6 justify-content-center">
            
            <a class="btn btn-success" href="/AWP_webapp/allotprofessionalservlet?value=<%=s.getId() %>">Confirm </a>
            
        </div>    
            
        <div class="col-sm-6 justify-content-center">  
            
             <a class="btn btn-danger" href="/AWP_webapp/userservicesservlet?value=<%=s.getPackage_id()%>">Cancel</a>
            
        </div>    
        
    </div>
            
    
            
        
        
            <h2>  ${error_message} </h2>
           
        
  
    
    
    

</div>





<jsp:include page="footer.jsp"/> 
