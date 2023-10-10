<%--
  Created by IntelliJ IDEA.
  User: yukunpeng
  Date: 2023/4/1
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改课程信息</title>
</head>
<body>
    <h3 align="center">修改课程信息</h3>
    <hr/>
    <br/>
    <form action="lessonupdate" method="post">
        <table align="center" border="1">
            <tr>
                <th>申请编号</th>
                <td><input type="text" value="${lesson.code}" name="code" /> </td>
            </tr>
            <tr>
                <th>课程名称</th>
                <td><input type="text" value="${lesson.lessonname}" name="lessonname"/> </td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit"/> </td>
            </tr>
        </table>
    </form>

</body>
</html>
