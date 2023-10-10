<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/22
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>系统用户管理</title>
    <script language="JavaScript" type="application/javascript">
        function add() {
            window.location.href="useradd.jsp";
        }
        function del(username) {
                var flag = confirm("确定删除该用户吗？")
                if(flag) window.location.href = "userdel?username=" + username;

        }
        function update(username){
            window.location.href = "userupdate.jsp?username="+username;
        }
        function back() {
            window.location.href="administrators.jsp";
        }


    </script>
</head>
<body>
<h3 align="center">用户信息</h3>
<hr/>
<br/>
<div align="center">
    <input type="button" value="新建用户" onclick="add()"/>
</div>
<br/>
<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>身份</th>
        <th>操作</th>

    </tr>
    <c:forEach items="${list}" var="user" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.identity}</td>
            <td><input type="button" value="删除" onclick="del('${user.username}')"/> &nbsp;&nbsp;
                <input type="button" value="修改" onclick="update('${user.username}')"/></td>

        </tr>
    </c:forEach>
</table>
<br/>
<div align="center">
    <input type="button" value="返回" onclick="back()"/>
</div>
<br/>

</body>
</html>
