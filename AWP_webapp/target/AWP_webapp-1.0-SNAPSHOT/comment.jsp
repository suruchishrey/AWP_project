<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<html>
<head></head>
<body>
<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
                   url = "jdbc:mysql://localhost:3306/proserv"
                   user = "root"  password = "root"/>

<sql:query dataSource = "${snapshot}" var = "result">
    SELECT * from reviews;
</sql:query>

<table border = "1" width = "100%">
    <tr>
        <th>customer ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Rating</th>
        <th>Comment</th>
    </tr>
    <c:forEach var = "row" items = "${result.rows}">
        <tr>
            <td><c:out value = "${row.id}"/></td>
            <td><c:out value = "${row.fname}"/></td>
            <td><c:out value = "${row.lname}"/></td>
            <td><c:out value = "${row.email}"/></td>
            <td><c:out value = "${row.star}"/></td>
            <td><c:out value = "${row.comments}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>