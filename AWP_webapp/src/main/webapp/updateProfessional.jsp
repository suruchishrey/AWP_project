 <%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "proserv";
String userid = "root";
String password = "Suruchi@2001";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from professionals where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="SignUp.css">
    <title>Update details</title>
    </head>
<body>
<h1>Update data from database in jsp</h1>
<div class="contentProfessional">
<form method="post" action="updateProfDetails">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
<%--<input type="text" name="id" value="<%=resultSet.getString("id") %>">--%>
<br>
<label>Name:</label>
<div>
<input type="text" name="name" value="<%=resultSet.getString("name") %>" id="field">
</div>
<br>
<label>Username:</label>
<div>
<input type="text" name="username" value="<%=resultSet.getString("username") %>" id="field">
</div>
<br>
<label>Password:</label>
<div>
<input type="text" name="password" value="<%=resultSet.getString("password") %>" id="field"></div>
<br>
<label>Profession:</label>
<div>
<input type="text" name="profession" value="<%=resultSet.getString("profession") %>" id="field"></div>
<br>
<label>Email Id:</label>
<div>
<input type="email" name="email" value="<%=resultSet.getString("email") %>" id="field"></div>
<br>
<label>Mobile Number:</label>
<div>
<input type="text" name="mob_no" value="<%=resultSet.getString("mob_no") %>" id="field"></div>
<br>
<label>Address:</label>
<div>
<input type="text" name="address" value="<%=resultSet.getString("address") %>" id="field"></div>
<br>
<label>Gender:</label>
<div>
<input type="text" name="gender" value="<%=resultSet.getString("gender") %>" id="field"></div>
<br>
<label>Status(free/busy):</label>
<div>
<input type="text" name="status" value="<%=resultSet.getString("status")%>" id="field"></div>
<br>

<br>
<button type="submit"  id="button">submit</button>
</form>
</div>
<%
}
connection.close();
} catch (Exception e) {
out.println(e.getMessage());
}
%>
</body>
</html> 