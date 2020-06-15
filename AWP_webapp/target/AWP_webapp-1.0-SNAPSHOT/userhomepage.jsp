<%-- 
    Document   : userhomepage
    Created on : 19-Apr-2020, 6:46:32 PM
    Author     : kumar
--%>

<%@page import="dataservices.Packageservices"%>
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

<div class="container-fluid">
    
    <br>
    <br>
    <div id="demo" class="p-3 carousel slide" data-ride="carousel">

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/img_carousal_1.jpg" alt="Los Angeles">
    </div>
    <div class="carousel-item">
      <img src="images/img_carousal_2.jpg" alt="Chicago">
    </div>
    <div class="carousel-item">
      <img src="images/img_carousal_3.jpg" alt="New York">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
    </div>  
    
   
    <div class="p-3 bg-dark text-white" id="package_head">
        <h1>Our Service Packages</h1>
    </div>
    
    <br>

    
    <div class="row">

        <%
            Packageservices pserv = new Packageservices();
            ArrayList<Packages> packlist1 = new ArrayList<Packages>();
            packlist1 = pserv.getAllPackages();
            List<Packages> packlist = (List<Packages>)packlist1;
            
            for(Packages p : packlist)
            {
             
        %>
        <div class="col-sm-4">
            

            <div class="card p-3">
                <img class="card-img-top" src=<%=p.getImage_url()%> alt="Cardimage" style="width:match-parent; height:300px">
              <div class="card-body">
                <h4 class="card-title"><%=p.getName()%></h4>
                <p class="card-text">Best of the <%=p.getName()%> in industry</p>
                <a href="/AWP_webapp/userservicesservlet?value=<%=p.getId()%>" class="btn btn-primary">See Details</a>
              </div>
            </div>
            
        </div> 
       
        <%
            }
            
         %>  
         
    </div>     


</div>

<jsp:include page="footer.jsp"/> 

