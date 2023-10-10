<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/23
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加课程</title>
</head>
<body>
<form name="form1" action="addlesson" method="get">
    <table align="center" border="1">
        <tr>
            <th>课程名称</th>
            <td><input type="text"  name="lessonname" /> </td>
        </tr>
        <tr>
            <th>主讲教师</th>
            <td><input type="text"  name="teacher" /> </td>
        </tr>
        <tr>
            <th>主管教师</th>
            <td><input type="text"  name="manager" /> </td>
        </tr>
        <tr>
            <td colspan="2" align="right"> <input type="submit" value="提交"/>  </td>
        </tr>
    </table>
</form>

</body>
</html>
