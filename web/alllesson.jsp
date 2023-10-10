<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/24
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>所有申请</title>
    <script language="JavaScript" type="application/javascript">
        function back() {
            window.location.href="administrators.jsp";
        }
        function del(code){
            var flag = confirm("确定删除该条数据吗？")
            if(flag) window.location.href = "lessondel?code=" + code;
        }
    </script>
</head>
<body>
<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>申请代码</th>
        <th>申请课程</th>
        <th>申请人</th>
        <th>主讲教师审批结果</th>
        <th>主管教师审批结果</th>
        <th>申请理由</th>
        <th>主讲教师驳回理由</th>
        <th>主管教师驳回理由</th>
        <th>操作</th>



    </tr>
    <c:forEach items="${list}" var="lesson" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${lesson.code}</td>
            <td>${lesson.lessonname}</td>
            <td>${lesson.applicant}</td>
            <td>${lesson.sdata}</td>
            <td>${lesson.sdata2}</td>
            <td>${lesson.applyreason}</td>
            <td>${lesson.reason1}</td>
            <td>${lesson.reason2}</td>
            <td><input type="button" value="删除" onclick="del('${lesson.code}')"/>
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
