<%-- 
    Document   : indexProfessional
    Created on : 10 Apr, 2020, 2:09:47 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <title>Index</title>
</head>
<body>
    <h1>Welcome to Pro-Serv</h1>
    <main>
        <div class="content">
            <div class="tabs">
                <a href="index.jsp"><div class="tabsData">User</div></a>
                <div class="tabsData" id="current">Professional</div>
                <a href="indexAdmin.jsp"><div class="tabsData">Admin</div></a>
                <!-- <br> -->
            </div>
            <br>
            <br>
            </span align="center"><label for="page" id="head">Lets get started</label>
            <br>
            <form action ="loginprof_servlet" method="post">
            <label for="username">Username</label>
            <input type="text" name="name" id="username" placeholder="Username" required>
            <br>
            <label for="password">Password</label>
            <input type="password" name="pass" id="password" placeholder="Password" required>
            <br>
            <button type="submit">Log in</button>
            <p style="color: greenyellow">${success_message}</p>
             <p style="color:red">${message}</p>
              <p style="color:greenyellow">${logoutmessage}</p>
            </form>
            <!-- <br>
            <div class="signUP">
                New to Pro-Serv? Join us here <button>Sign Up</button>
            </div> -->
        </div>
        <br>
        <div class="extra">
            <div class="signUP">
                New to Pro-Serv ? Join us here <a href="professionalSignUp.jsp"><button>Sign Up</button></a>
            </div>
        </div>
    </main>
    <br>
    <!-- <footer>
        &copy; Pro-Serv 2022
    </footer> -->
</body>
</html>