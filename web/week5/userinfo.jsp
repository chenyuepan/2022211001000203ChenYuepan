<%--
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

<body>
<table>
    <tr><td>Username: </td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password: </td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>Email: </td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>Gender: </td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>Birth Date: </td><td><%=request.getAttribute("birthDate")%></td></tr>
</table>
</body>
</html>
<%@include file="footer.jsp"%>
