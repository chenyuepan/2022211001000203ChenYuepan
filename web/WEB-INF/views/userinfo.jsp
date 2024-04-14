<%@ page import="org.ChenYuepan.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/4/6
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>User Info</title>
</head>
<%
    User user =(User) request.getAttribute("user");
%>
<body>
<table>
    <tr><td>Username: </td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password: </td><td><%=user.getPassword()%></td></tr>
    <tr><td>Email: </td><td><%=user.getEmail()%></td></tr>
    <tr><td>Gender: </td><td><%=user.getGender()%></td></tr>
    <tr><td>Birth Date: </td><td><%=user.getBirthDay()%></td></tr>
</table>
</body>
</html>
<%@include file="footer.jsp"%>
