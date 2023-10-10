<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/23
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>课程信息</title>
    <script language="JavaScript" type="application/javascript">
        function add() {
            window.location.href="addlesson.jsp";
        }
        function back() {
            window.location.href="administrators.jsp";
        }
        function del(lessonnamename) {
            var flag = confirm("确定删除该课程吗？")
            if(flag) window.location.href = "lessondelbyadmins?lessonname=" + lessonnamename;

        }
        function update(){
            window.location.href = "lessonupdatebyadmins.jsp";
        }



    </script>
</head>
<h3 align="center">课程信息列表</h3>
<hr/>
<br/>
<div align="center">
    <input type="button" value="新建课程" onclick="add()"/>
</div>
<br/>
<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>课程名称</th>
        <th>主讲教师</th>
        <th>主管教师</th>
        <th>操作</th>

    </tr>
    <c:forEach items="${list}" var="lessonmanage" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${lessonmanage.lessonname}</td>
            <td>${lessonmanage.teacher}</td>
            <td>${lessonmanage.manager}</td>
            <td><input type="button" value="删除" onclick="del('${lessonmanage.lessonname}')"/> &nbsp;&nbsp;
                <input type="button" value="更改" onclick="update()"/></td>
        </tr>
    </c:forEach>
</table>
<br/>
<div align="center">
    <input type="button" value="返回" onclick="back()"/>
</div>
<br/>
</html>
