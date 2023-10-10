<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/22
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户添加</title>
    <script language="JavaScript" type="application/javascript">
        function back1() {
            window.history.back();
        }

    </script>
</head>
<body>
<div align="right">
    <input type="button" value="返回" onclick="back1()"/>
</div>
<form name="form1" action="useradd" method="post">
    <table align="center" border="1">
        <tr>
            <th>用户名</th>
            <td><input type="text"  name="username" /> </td>
        </tr>

        <tr>
            <th>密码</th>
            <td><input type="text"  name="password" /> </td>
        </tr>

        <tr>
            <th>身份</th>
            <td><input type="text"  name="identity" /> </td>
        </tr>
        <tr>
            <td colspan="2" align="right"> <input type="submit" value="提交"/>  </td>
        </tr>
    </table>
</form>

</body>
</html>
