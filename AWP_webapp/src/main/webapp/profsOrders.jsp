<%-- 
    Document   : profsOrders
    Created on : Jun 15, 2020, 7:10:48 PM
    Author     : Dell
--%>

<%@page import="datapack.Services"%>
<%@page import="java.util.List"%>
<%@page import="datapack.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/> 

<div class="container-fluid">
        <div id="ajax"></div>
        <br><br>
    <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th>User Name</th>
        <th>User Email</th>
        <th>User Mobile no.</th>
        <th>Service Name</th>
        <th>Service Description</th>
      </tr>
    </thead>
    <tbody>
        <%
            List<Users> userlist = (List<Users>)request.getAttribute("userlistorder");
            List<Services> servlist=(List<Services>)request.getAttribute("servlistorder");
            for(int i=0;i<userlist.size();++i)
            {
                Users u=userlist.get(i);
                Services s=servlist.get(i);
        %>
        <tr> 
            <td><%=u.getname()%></td>
            <td><%=u.getemail()%></td>
            <td><%=u.getmob_no()%></td>
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
