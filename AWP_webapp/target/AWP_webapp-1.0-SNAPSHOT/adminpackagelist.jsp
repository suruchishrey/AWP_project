<%-- 
    Document   : adminpackagelist
    Created on : 22-May-2020, 7:16:04 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datapack.Packages" %>
<%@page import="java.util.*"%>

<jsp:include page="header.jsp"/> 

<style>
    img{
        
        width:100%;
        height:400px;
        
    }
    
    #package_head{
    
        border-radius: 5px;
        text-align: center;
    
    }
</style>    
    <br>
    <br>

    <div class="p-3 bg-dark text-white" id="package_head">
        <h1>Packages</h1>
    </div>
    
   

    
    <div class="row">

        <%
            List<Packages> packlist = (List<Packages>)request.getAttribute("packagelist");
            
            for(Packages p : packlist)
            {
             
        %>
        <div class="col-sm-4">
            

            <div class="card p-3">
                <img class="card-img-top" src=<%=p.getImage_url()%> alt="Cardimage" style="width:match-parent; height:300px">
              <div class="card-body">
                <h4 class="card-title"><%=p.getName()%></h4>
                <p class="card-text">Best of the <%=p.getName()%> in industry </p>
                <a href="addnewservice.jsp?package_id=<%=p.getId()%>" class="btn btn-primary">Add a service</a>
              </div>
            </div>
            
        </div> 
       
        <%
            }
            
         %>  
         
    </div>     
        
  <jsp:include page="footer.jsp"/>  