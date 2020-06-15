<%-- 
    Document   : profdetails
    Created on : 03-Apr-2020, 8:27:40 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="datapack.Users"%>

<jsp:include page="header.jsp"/> 

<br>
<br>

<div class="container-fluid">    
    <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Mobile no</th>
        <th>gender</th>
        <th>address</th>
        
      </tr>
    </thead>
    <tbody>
        
       
        
        <%
            List<Users> userli = (List<Users>)request.getAttribute("userlist");
            
            for(Users u : userli)
            {
             
        %>
     
      <tr>
        <td><%=u.getid()%></td>
        <td><%=u.getname()%></td>
        <td><%=u.getemail()%></td>         
          <td><%=u.getmob_no()%></td>
          <td><%=u.getgender()%></td>
          <td><%=u.getaddress()%></td>
          
      </tr>
      
      </a>
     
        <%
            }
            
         %>   
            
          </tbody>
  </table>
</div>      
        
        
        
   <jsp:include page="footer.jsp"/> 


