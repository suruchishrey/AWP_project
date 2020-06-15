<%-- 
    Document   : usersOrders
    Created on : Jun 15, 2020, 6:38:03 PM
    Author     : Dell
--%>

<%@page import="datapack.Services"%>
<%@page import="java.util.List"%>
<%@page import="datapack.Professionals"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/> 

<div class="container-fluid">
        <div id="ajax"></div>
        <br><br>
    <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th>Professional Name</th>
        <th>Professional Email</th>
        <th>Professional Mobile no.</th>
        <th>Service Name</th>
        <th>Service Description</th>
      </tr>
    </thead>
    <tbody>
        <%
            List<Professionals> profli = (List<Professionals>)request.getAttribute("proflistorder");
            List<Services> servlist=(List<Services>)request.getAttribute("servlistorder");
            for(int i=0;i<profli.size();++i)
            {
                Professionals e=profli.get(i);
                Services s=servlist.get(i);
        %>
        <tr> 
            <td><%=e.getname()%></td>
            <td><%=e.getemail()%></td>
            <td><%=e.getmob_no()%></td>
            <td><%=s.getName()%></td>
            <td><%=s.getDescription()%></td>
        </tr>
        <%
            }
         %>   
           
         
          </tbody>
    </table>
    </div>    
 <jsp:include page="footer.jsp"/> 
