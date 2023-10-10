<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/22
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>管理员系统</title>
    <script language="JavaScript" type="application/javascript">

        function usermanagement(){
            window.location.href = "usermanagement" ;
        }
        function lessonmanagement() {
            window.location.href="lessonnamagement";
        }
        function alllesson() {
            window.location.href="alllesson";
        }
        function downloadlesson() {
            window.location.href="allpasslesson";
        }
        function loginout() {
            window.location.href="loginout";
        }
    </script>
</head>
<body>
<br/>
<div align="right">
    <input type="button" value="退出登录" onclick="loginout()"/>
</div>
<div align="center">
    <input type="button" value="系统用户管理" onclick="usermanagement()"/>
</div>
<br/>

<br/>
<div align="center">
    <input type="button" value="申请课程与用户审批权限管理" onclick="lessonmanagement()"/>
</div>
<br/>

<br/>
<div align="center">
    <input type="button" value="审批记录" onclick="alllesson()"/>
</div>
<br/>

<br/>
<div align="center">
    <input type="button" value="导出审批通过记录" onclick="downloadlesson()"/>
</div>
<br/>


</body>
</html>
