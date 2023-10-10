<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/16
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="edu.neu.management.bean.Lesson" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    int nowPage = Integer.parseInt(request.getAttribute("page").toString());
    int totalPage = Integer.parseInt(request.getAttribute("totalPage").toString());
    if (nowPage>totalPage)
        nowPage=totalPage;
%>

<html>
<head>
    <title>Title</title>
</head>
<script language="JavaScript" type="application/javascript">
    function reset() {
        window.location.href = "studentlesson?page=1"
    }
    function lastPage(nowPage) {
        var page = Number(nowPage);
        window.location.href = "lessonpage?page=" + (page-1)
    }
    function nextPage(nowPage) {
        var page = Number(nowPage);
        window.location.href = "lessonpage?page=" + (page+1)
    }

    function back() {
        window.location.href="studentlesson?page="+1;
    }

</script>
<body>
<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>申请代码</th>
        <th>申请课程</th>
        <th>申请人</th>
        <th>主讲教师审批情况</th>
        <th>主管教师审批情况</th>
        <th>主讲教师驳回理由</th>
        <th>主管教师驳回理由</th>


    </tr>
    <c:forEach items="${list}" var="lesson" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${lesson.code}</td>
            <td>${lesson.lessonname}</td>
            <td>${lesson.applicant}</td>
            <td>${lesson.sdata}</td>
            <td>${lesson.sdata2}</td>
            <td>${lesson.reason1}</td>
            <td>${lesson.reason2}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<div align="center">
    <input type="button" value="上一页" onclick="lastPage('<%=nowPage%>')"/>
    <label>第<%=nowPage%>/<%=totalPage%>页</label>
    <input type="button" value="下一页" onclick="nextPage('<%=nowPage%>')"/>
</div>
<br/>
<div align="center">
    <input type="button" value="返回" onclick="back()"/>
</div>
<br/>


</body>
</html>
