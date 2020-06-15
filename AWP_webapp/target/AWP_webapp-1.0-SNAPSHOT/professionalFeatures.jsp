<%-- 
    Document   : professionalFeatures
    Created on : Apr 19, 2020, 9:10:43 PM
    Author     : Dell
--%>

<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
  <div class="row">
    <div class="col-sm">
      <%--<button><a href="updateProfessional.jsp?id=<%=id%>">Change Status</a></button>--%>
    </div>
    <div class="col-sm">
        <% 
            String id;
            id=(String)request.getAttribute("value");
        %>
       <button type="button" class="btn btn-outline-primary"><a href="updateProfessional.jsp?id=<%=id%>">update</a></button>
    </div>
    <div class="col-sm">
      <button type="button" class="btn btn-outline-primary"><a href="LogoutProfessional">Logout</a></button>
    </div>
    <div class="col-sm">
      <button type="button" class="btn btn-outline-primary"><a href="/AWP_webapp/changeProfAvailability?value=<%=id%>">Change Availability</a></button>
      <p style="color:red">${message}</p>
    </div>
  </div>
</div>
       
    </body>
</html>
