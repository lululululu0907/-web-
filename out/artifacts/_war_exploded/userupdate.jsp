<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/22
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<h3 align="center">修改用户信息</h3>
<hr/>
<br/>
<form action="userupdate" method="post">
    <table align="center" border="1">
        <tr>
            <th>用户名</th>
            <td><input type="text" value="${user.username}" name="username" /> </td>
        </tr>
        <tr>
            <th>新密码</th>
            <td><input type="text" value="${user.password}" name="password"/> </td>
        </tr>
        <tr>
            <th>新身份</th>
            <td><input type="text" value="${user.identity}" name="identity"/> </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit"/> </td>
        </tr>
    </table>
</form>

</body>
</html>