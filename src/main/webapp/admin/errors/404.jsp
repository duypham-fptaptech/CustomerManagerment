<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 5/14/2022
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String message = (String) request.getAttribute("message");
%>
<html>
<head>
    <title><%=message%></title>
</head>
<body>
<h1><%=message%></h1>
<img src="https://webdeasy.de/wp-content/uploads/2020/06/404-pages.jpg" alt="<%=message%>">
</body>
</html>
