<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/23
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更改</title>
</head>
<body>
<form action="lessonupdatebymins" method="post">
    <table align="center" border="1">
        <tr>
            <th>课程名称</th>
            <td><input type="text" value="${lessonmanage.lessonname}" name="lessonname" /> </td>
        </tr>
        <tr>
            <th>主讲教师</th>
            <td><input type="text" value="${lessonmanage.teacher}" name="teacher"/> </td>
        </tr>

        <tr>
            <th>主管教师</th>
            <td><input type="text" value="${lessonmanage.manager}" name="manager"/> </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit"/> </td>
        </tr>
    </table>
</form>

</body>
</html>
