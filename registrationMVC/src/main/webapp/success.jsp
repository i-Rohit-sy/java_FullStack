<%--
  Created by IntelliJ IDEA.
  User: ark
  Date: 4/12/26
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<h1>Registration Success</h1>
<% String name = (String) session.getAttribute("name"); %>
<h2><%= name %> You have Registered Here Congratulations</h2>
</body>
</html>
