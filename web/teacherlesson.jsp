<%@ page import="java.util.List" %>
<%@ page import="edu.neu.management.bean.Lesson" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/4/13
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
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
    <title>同意申请记录</title>
</head>
<script language="JavaScript" type="application/javascript">
    function reset() {
        window.location.href = "teacherlesson?page=1"
    }
    function lastPage(nowPage) {
        var page = Number(nowPage);
        window.location.href = "page?page=" + (page-1)
    }
    function nextPage(nowPage) {
        var page = Number(nowPage);
        window.location.href = "page?page=" + (page+1)
    }
    function searchbylessonname() {
        var objs= document.getElementById("multipleSelect");
        var index = objs.selectedIndex;
        var lessonname = objs.options[index].text;
        window.location.href = "selectbylessonname?page=1&lessonname="+lessonname;

    }
    function back() {
        window.location.href="teacher";
    }
    function searchbysudentname() {
        var studentname= document.getElementById("name").value;
        window.location.href = "selectbystudentname?page=1&studentname="+studentname;

    }

</script>
<body>
    <input type="button" value="重置" onclick="reset()">
        <div align="center">
            <label>课程名称</label>
            <select id="multipleSelect" name="lessonname" style="width:175px" >
             <c:forEach items='${namelist}' var="name" varStatus="status">
                <option value='${name}'>${name}</option>
             </c:forEach>
            </select>
            <input type="button" onclick="searchbylessonname()" value="查询" >
        </div>



    <div align="center">
        <table id="studentname">
            <tr>
                <th>按姓名查找</th>
                <td><input type="text" id="name"></td>
                <td><input type="submit" value="查询" onclick="searchbysudentname()"></td>

            </tr>
        </table>
    </div>




<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>申请代码</th>
        <th>申请课程</th>
        <th>申请人</th>
        <th>申请理由</th>
        <th>主讲教师审批状态</th>
        <th>主管教师审批状态</th>
        <th>主讲教师驳回理由</th>
        <th>主管教师驳回理由</th>


    </tr>
    <c:forEach items="${list}" var="lesson" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${lesson.code}</td>
            <td>${lesson.lessonname}</td>
            <td>${lesson.applicant}</td>
            <td>${lesson.applyreason}</td>
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
