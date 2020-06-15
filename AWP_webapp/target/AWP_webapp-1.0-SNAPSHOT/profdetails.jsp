<%-- 
    Document   : profdetails
    Created on : 03-Apr-2020, 8:27:40 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="datapack.Professionals"%>

<jsp:include page="header.jsp"/> 

<script>
    
    var val;
    
    function loadDoc(val) {
      var xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
         document.getElementById("ajax").innerHTML = this.responseText;
        }
      };
      xhttp.open("GET", "/AWP_webapp/getprofessionals?value="+val, true);
      xhttp.send();
    }
</script>
<br>
<br>

<div class="container-fluid row">
    
    <div class="col-sm-9">
        
    </div>   
    
    <div class="col-sm-3">

<form action=""> 
    
  <p> Filter by profession :<p/> 
  <select name="profesionals" class="form-control" onchange="loadDoc(this.value)">
             <option value="default">Select a profession:</option>
              <option value="1">Room Cleaning</option>
              <option value="2">Car Cleaning</option>
              <option value="3">Washroom Cleaning</option>
              <option value="4">Water Repairs</option>
              <option value="5">Electrical Repairs</option>
              <option value="6">Vehicle Repairs</option>
              <option value="7">Home Tutor</option>
              <option value="8">Music Tutor</option>
              <option value="9">Yoga Tutor</option>
              <option value="10">Art Tutor</option>
  </select>
</form>
     
    </div>     
<br>

</div>



<div class="container-fluid">    
    <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Profession</th>
        <th>Mobile no.</th>
        <th>View Details</th>
        
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
      </tr>
      
      </a>
     
        <%
            }
            
         %>   
            
          </tbody>
  </table>
</div>      
        
        
        
   <jsp:include page="footer.jsp"/> 

