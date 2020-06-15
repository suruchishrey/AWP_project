<%-- 
    Document   : newprofdetails
    Created on : Jun 2, 2020, 7:21:33 PM
    Author     : Dell
--%>

<%@page import="java.util.List"%>
<%@page import="datapack.Professionals"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/> 
<script>
    var val1,val2;
    function newprofs(val1,val2) {
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
         document.getElementById("ajax").innerHTML = this.responseText;
        }
      };
      xhttp.open("GET", "/AWP_webapp/NewProfApprovalServlet?value="+val1+"&approve="+val2, true);
      xhttp.send();
    }
</script>
    <div class="container-fluid">
        <div id="ajax"></div>
    <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Profession</th>
        <th>Mobile no.</th>
        <th>View Details</th>
        <th>Approve or Not</th>
      </tr>
    </thead>
    <tbody>
        
       
        
        <%
            List<Professionals> profli = (List<Professionals>)request.getAttribute("proflist");
            
            for(Professionals e : profli)
            {
             
        %>
     
      <tr>
        <td><%=e.getid()%></td>
        <td><%=e.getname()%></td>
        <td><%=e.getemail()%></td>
         <td><%=e.getprofession()%></td>
          <td><%=e.getmob_no()%></td>
          <td><a href="/AWP_webapp/Profileservlet?value=<%=e.getid()%>">view...</a></td>
          <td><button class="btn btn-success" onclick="newprofs(<%=e.getid()%>,1)">Approve</button>
          <button class="btn btn-danger" onclick="newprofs(<%=e.getid()%>,0)">Disapprove</button></td>
          
      </tr>
      
      </a>
     
        <%
            }
            
         %>   
            
          </tbody>
    </table>
    </div>    
 <jsp:include page="footer.jsp"/> 

