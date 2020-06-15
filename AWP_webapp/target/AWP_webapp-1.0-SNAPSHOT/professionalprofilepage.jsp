<%-- 
    Document   : professionalprofilepage
    Created on : 03-Apr-2020, 11:41:21 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="datapack.Professionals"%>

<jsp:include page="header.jsp"/> 


 
  <style>
      .img-fluid {
 
  width: 25%;
  height:25%;
  display: block;
  margin-left: auto;
  margin-right: auto;
  border-radius: 50%;
  
      }
      
   .container
   {
       border-radius: 20px;
   }
  


   </style>
  
  
  
</head>
<body>
    
    <%
    
        Professionals p = new Professionals();
        p=(Professionals)request.getAttribute("prof");
             if(p==null)out.print("prof is null");
    %>
    
    <div class="container p-3 my-3 bg-dark text-white">
        
        <div class="row">
            
                <img src="images/img_avatar.png" alt="Avatar" class="img-fluid">
                
        </div>   
        
        <br>
        <br>
        
        <div class="row">
            
          <div class="col-sm-6"> 
              
            <p>Id : <%=p.getid() %></p>
            <p>Name : <%=p.getname() %></p>
            <p>Gender : <%=p.getgender()%></p>
            <p>Email : <%=p.getemail() %></p>
            <p>Mobile no : <%=p.getmob_no() %></p>
            
          </div>
            
          <div class="col-sm-6">   
            
            <p>Profession : <%=p.getprofession() %></p>
            <p>Status : <%=p.getstatus()%></p>
            <p>Rating : <%=p.getrating() %></p>
            <p>Salary : <%=p.getsalary() %></p>
            <p>Total Services : <%=p.gettotal_services()%></p>
         
          </div> 
            
        </div>
        
        
        
    </div>
            
           

    <jsp:include page="footer.jsp"/> 
    
  