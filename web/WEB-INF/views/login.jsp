<%--
  Created by IntelliJ IDEA.
  User: 31586
  Date: 2024/3/28
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<h1>Login</h1> <br>
<%
    if(request.getParameter("message")!=null){
        out.println("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<html>
<head>
    <title>Login</title>
</head>
<body>
  <form method="post" action="/2022211001000203ChenYuepan/login">
      <ul>
          <li><input id="username" type="text" name="username" placeholder="Username" class="da"></li>
          <li><input id="password" type="password" name="password" placeholder="password" class="da"></li>
          <li class="xiao"> <input type="submit" value="Login" ></li>
      </ul>
  </form>
</body>
</html>
<%@ include file="footer.jsp"%>
