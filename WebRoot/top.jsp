<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <base target="main">
    <title>My JSP 'top.jsp' starting page</title>
</head>
<body style="text-align: center;">
    <h1>客户管理系统</h1>
    <a href="./add.jsp">添加客户</a>
    <a href="${pageContext.request.contextPath }/customer?method=findAll">查询客户</a>
    <a href="./query.jsp">高级搜索</a>

</body>
</html>
