<%@ page import="java.util.List" %>
<%@ page import="edu.neu.management.bean.Lessonmanage" %>
<%@ page import="edu.neu.management.utils.DB" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/4/15
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    List<Lessonmanage>list = DB.queryLesson_Name();
    int i = 0;
%>
<html>
<head>
    <title>添加信息</title>
    <script language="JavaScript" type="application/javascript" >
        function submitall() {
            document.form1.submit();
            document.form2.submit();
        }
        function backkk() {
            window.history.back();

        }
    </script>
</head>
<body>
<h3 align="center">添加申请</h3>
</div>
<div align="left">
    <input type="button" value="返回" onclick="backkk()"/>
</div>
<hr/>
<br/>
<form name="form1" action="lessonadd" method="post">
    <table align="center" border="1">
        <tr>
            <th>课程名称</th>
            <td style="size: 300px">

                <select id="multipleSelect" name="lessonname" style="width:175px" >
                    <c:forEach items='<%=list%>' varStatus="status">
                        <option value=<%=list.get(i).getLessonname()%>><%=list.get(i++).getLessonname()%></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <th>申请理由</th>
        <td><input type="text"  name="applyreason" /> </td>
        </tr>
        <tr>
        <td colspan="2" align="right"> <input type="submit" value="提交"/>  </td>
        </tr>
    </table>
</form>
<div align="center">
<form name="form2" action="upload"enctype="multipart/form-data"method="post">

    <input type="file"name="f1"/>
</form>
    <input type="button" value="提交" onclick="submitall()"/>
</div>
</body>
</html>