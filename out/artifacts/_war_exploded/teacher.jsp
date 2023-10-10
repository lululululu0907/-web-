<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/4/13
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>申请记录列表</title>
    <script language="JavaScript" type="application/javascript">

        function update(code){
            window.location.href = "lessonappoval.jsp?code=" + code;
        }
        function querypass(){
            window.location.href = "teacherlesson?page=1";
        }
        function lessonfiles() {
            window.location.href= "listfiles";
        }
        function loginout() {
            window.location.href="loginout";

        }


    </script>
</head>
<body>
<h3 align="center">申请信息表</h3>
<hr/>
<br/>
<div align="right">
    <input type="button" value="退出登录" onclick="loginout()"/>
</div>
<div align="center">
    <input type="button" value="查看已审批的申请" onclick="querypass()"/>
</div>
<br/>


<div align="center">
    <input type="button" value="查看申请证明"  onclick="lessonfiles()"/>
</div>


<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>申请代码</th>
        <th>申请课程</th>
        <th>申请人</th>
        <th>申请理由</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    <c:forEach items="${list}" var="lesson" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${lesson.code}</td>
            <td>${lesson.lessonname}</td>
            <td>${lesson.applicant}</td>
            <td>${lesson.applyreason}</td>
            <td>${lesson.sdata}</td>
            <td>
                <input type="button" value="审批" onclick="update('${lesson.code}')"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
