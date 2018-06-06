<%--
  Created by IntelliJ IDEA.
  User: ty
  Date: 2018/5/4
  Time: 下午12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.min.css"/>
</head>
<body>

<br/>
<br/>
<br/>
<center><h2>${message}</h2></center>
<br/>
<center>
    <a href="<%=basePath%>/user/index.do">
        <button type="button" class="btn btn-primary btn-lg">点击我返回登录</button>
    </a>
</center>
</body>
</html>
