<%-- 
    Document   : listreview
    Created on : 25-May-2020, 10:32:26 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="datapack.Reviews" %>
<%@page import="java.util.List" %>
<jsp:include page="header.jsp"/>

<style>
    
    img{
        border-radius: 50%;
    }
    
    #package_head{
    
        border-radius: 5px;
        text-align: center;
    }
    
    .fa_custom{
        
        color: yellow;
    }
    
    .card{
        
        border-radius: 5px;
        border-bottom: 3px solid grey;
        transition-duration: 1000ms;
        box-shadow: none;
    }
    
    
    .card:hover{
        
        transform: scale(1.008);
        box-shadow: 1px 1px 1px 1px grey;
    }
</style>    
    <br>
    <br>
  <div class="container">
      
    <div class="p-3 bg-secondary text-white" id="package_head">
        <h4>Reviews</h4>
    </div>
    <br>
  

        <%
            List<Reviews> reviewlist = (List<Reviews>)request.getAttribute("reviewlist");
            
            for(Reviews re : reviewlist)
            {
             
        %>
       
            <div class="card p-2">
              <div class="card-body">
                
                <div class="row">
                    
                    <div class="col-sm-2">
                        <img style="width:100px;"src="images/img_avatar.png"/>
                    </div>
                        
                    <div class="col-sm-10">
                        <h4 class="card-title">Username: <%=re.getName()%></h4>
                        <p class="card-text">Review: <%=re.getComment()%></p>
                        <%
                            for(int i=0;i<5;i++)
                            {
                        %>
                            <%if(i<Integer.parseInt(re.getRating())){%>
                        
                                <i class="fa fa-star fa_custom" style="font-size:24px"></i>
                            
                            <%}else{%>
                                <i class="fa fa-star " style="font-size:24px"></i>
                            <%}%>
                            
                        <%}%>
                    </div>
                </div>
              </div>
            </div>
            
      
       
        <%
            }
            
         %>  
         
    </div>     
        

<jsp:include page="footer.jsp"/>