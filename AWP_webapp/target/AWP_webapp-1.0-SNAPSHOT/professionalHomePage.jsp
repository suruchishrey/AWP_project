<%-- 
    Document   : professionalHomePage
    Created on : Apr 13, 2020, 8:11:35 PM
    Author     : Dell
--%>

<%@page import="datapack.Professionals"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page="header.jsp"/> --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           
        <%
            
                RequestDispatcher dispatcher = request.getRequestDispatcher("/Profileservlet");
                dispatcher.forward(request, response);
        %>
        <%--
        <br>
        <div class="row">
            <div class="col-sm">
              <button><a href="updateProfessional.jsp?id=<%=id%>">Change Status</a></button>
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
        <br>--%>
    </body>
</html>
