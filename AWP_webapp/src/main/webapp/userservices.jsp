<%-- 
    Document   : userservices
    Created on : 20-Apr-2020, 2:18:27 AM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="datapack.Services" %>
<%@page import="java.util.*"%>

<jsp:include page="header.jsp"/> 

    <style>
        
        #services_header{
            
            border-radius: 5px;
            text-align: center;
            
        }
        
        
    </style>    



    <br>
    <br>
    
    <div class="container-fluid">

        <div class="p-3 bg-info text-white" id="services_header">
            <h1>Our Services </h1>
        </div>

        <br>
        <br>

        <div class="row">


        <%
            List<Services> servlist = (List<Services>)request.getAttribute("servicelist");
            
            for(Services s : servlist)
            {
             
        %>
     
       <div class="col-sm-4">
        
            <div class="card p-3">
                <img class="card-img-top" src=<%=s.getImage_url()%> alt="Cardimage" style="width:match-parent; height:300px">
              <div class="card-body">
                <h4 class="card-title"><%=s.getName()%></h4>
                <h5 class="card-title"><%=s.getPrice()%></h5>
                
                <p class="card-text"><%=s.getDescription()%></p>
                <a href="/AWP_webapp/bookserviceservlet?value=<%=s.getId()%>" class="btn btn-primary">Book</a>
              </div>
            </div>
        
        </div>
     
        <%
            }
            

         %>  


    </div>

    </div>

<jsp:include page="footer.jsp"/> 


