<%--
  Created by IntelliJ IDEA.
  User: yukunpeng
  Date: 2023/4/1
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>申请课程信息列表</title>
    <script language="JavaScript" type="application/javascript">
        function del(code){
            var flag = confirm("确定删除该条数据吗？")
            if(flag) window.location.href = "lessondel?code=" + code;
        }
        function update(code){
            window.location.href = "lessonupdate.jsp?code=" + code;
        }
        function add(){
            window.location.href = "lessonadd.jsp";
        }
        function check(code){
            window.location.href="check?code="+code;
        }
        function conformed(code) {
            var flag=confirm("确定对申请进行确认吗？")
            if(flag)window.location.href="conform?code="+code;
        }
        function query(){
            window.location.href = "studentlesson?page=1";
        }
        function loginout() {
            window.location.href="loginout";

        }
    </script>
</head>
<body>
    <h3 align="center">课程信息列表</h3>

    <div align="right">
        <input type="button" value="退出登录" onclick="loginout()"/>
    </div>
    <hr/>
    <br/>
        <div align="center">
            <input type="button" value="新建申请" onclick="add()"/>
        </div>
    <br/>

    <br/>
    <div align="center">
        <input type="button" value="查看所有记录" onclick="query()"/>
    </div>
    <br/>


    <table align="center" border="1">
        <tr>
            <th>序号</th>
            <th>申请代码</th>
            <th>申请课程</th>
            <th>主讲教师审批</th>
            <th>主管教师审批</th>
            <th>申请理由</th>
            <th>操作</th>

        </tr>
        <c:forEach items="${list}" var="lesson" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${lesson.code}</td>
                <td>${lesson.lessonname}</td>
                <td>${lesson.sdata}</td>
                <td>${lesson.sdata2}</td>
                <td>${lesson.applyreason}</td>
                <td><input type="button" value="删除" onclick="del('${lesson.code}')"/> &nbsp;&nbsp;

                    <input type="button" value="查询进度" onclick="check('${lesson.code}')"/>&nbsp;&nbsp;
                    <input type="button" value="确认" onclick="conformed('${lesson.code}')"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
