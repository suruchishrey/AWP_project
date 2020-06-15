<%-- 
    Document   : header
    Created on : 04-Apr-2020, 1:04:13 PM
    Author     : kumar
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% String username = (String)session.getAttribute("username");
    String url="/AWP_webapp/adminlogoutservlet";
    String login_logout="Logout";
    String link1="";
    String link2="";
    String option1="";
    String option2=" ";
    String home="/AWP_webapp/userhomepage.jsp";
    String option4="Orders History";
    if(username==null){
        username="New User";
        url="/AWP_webapp/indexuser.jsp";
        login_logout="Login";
        option4="";
    }
   
        String currentuser=(String)session.getAttribute("current");
        if(currentuser!=null)
        {
            
            if(currentuser.equals("professional"))
            {
                String id;
            
                id=session.getAttribute("current_id").toString();
                link1="/AWP_webapp/updateProfessional.jsp?id="+id;
                link2="/AWP_webapp/changeProfAvailability?value="+id;
                option1="Update Details";
                option2="Change Availability";
                home="/AWP_webapp/Profileservlet?value="+id;
            }
            else if(currentuser.equals("admin"))
            {
                home="/AWP_webapp/adminhomepage.jsp";
            }
        }
        
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Proserv</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1 text/html">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body id="ajax">

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="#">Proserv</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item" id="edit">
          <a class="nav-link" href="<%=link1%>"><%=option1%></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=link2%>"><%=option2%></a><p style="color:red">${message}</p>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=home%>">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/AWP_webapp/OrderHistoryShowServlet"><%=option4%></a>
      </li>
    </ul>
      
  </div>  
  <div class="collapse navbar-collapse justify-content-end" id="navbarCollapse">
  <ul class="navbar-nav">
    <li class="nav-item">
        <button class="btn btn-dark">Hello <%= username %></button>
        <a href=<%=url%>><button class="btn btn-primary" ><%out.print(login_logout);%></button></a>
    </li>
  </ul>
</div>
</nav>
    
 
