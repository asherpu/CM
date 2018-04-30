<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">编辑客户</h3>
<form action="${pageContext.request.contextPath }/customer" method="post" >
	<input type="hidden" name="method" value="modifyCustomer"/>
    <input type="hidden" name="id" value="${customer.id}"/>
    <table border="0" align="center">
        <tr>
            <td width="100px">客户名称</td>
            <td>
                <input type="text" name="name" value="${customer.name}"/>
            </td>
        </tr>
        <tr>
            <td>客户性别</td>
            <td>
                 <input type="radio" name="gender" value="male" id="male" <c:if test="${customer.gender eq 'male'}">checked="checked"</c:if>/>
                <label for="male">男</label>
                <input type="radio" name="gender" value="female" id="female" <c:if test="${customer.gender eq 'female'}">checked="checked"</c:if> />
                <label for="female">女</label>
            </td>
        </tr>
        <tr>
            <td>手机</td>
            <td>
                <input type="text" name="phone" id="phone" value="${customer.phone}"/>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email" id="email" value="${customer.email}"/>
            </td>
        </tr>
        <tr>
            <td>描述</td>
            <td>
                <textarea rows="5" cols="30" name="description">${customer.description}</textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="submit" value="确定"/>
                <input type="reset" name="reset"/>
            </td>
        </tr>
    </table>
</form>


</body>
</html>
