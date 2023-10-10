<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/4/20
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>审批</title>
    <script language="JavaScript" type="application/javascript">
        function back1() {
            window.history.back();
        }

    </script>
</head>
<div align="right">
    <input type="button" value="返回" onclick="back1()"/>
</div>
<body>
<h3 align="center">审批</h3>
<hr/>
<br/>
<form action="lessonappoval" method="post">
    <table align="center" border="1">
        <tr>
            <th>申请编号</th>
            <td><input type="text" value="${lesson.code}" name="code" /> </td>
        </tr>
        <tr>
            <th>审批结果</th>
            <td><input type="text" value="${lesson.sdata}" name="sdata"/> </td>
        </tr>
        <tr>
            <th>驳回理由</th>
            <td><input type="text" value="${lesson.sdata}" name="reason1"/> </td>
        </tr>


        <tr>
            <td colspan="2" align="right"><input type="submit"/> </td>
        </tr>
    </table>
</form>

</body>
</html>
