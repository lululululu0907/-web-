<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/7
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主管教师审批</title>
</head>
<script language="JavaScript" type="application/javascript">

   function back1() {
       window.history.back();
   }
</script>
<body>
<h3 align="center">主管教师审批</h3>
<br/>
<div align="right">
    <input type="button" value="返回" onclick="back1()"/>
</div>
<br/>
<hr/>
<br/>
<form action="managerappoval" method="post">
    <table align="center" border="1">
        <tr>
            <th>申请编号</th>
            <td><input type="text" value="${lesson.code}" name="code" /> </td>
        </tr>
        <tr>
            <th>审批结果</th>
            <td><input type="text" value="${lesson.sdata2}" name="sdata2"/> </td>
        </tr>
        <tr>
        <tr>
            <th>审批理由</th>
            <td><input type="text" value="${lesson.reason2}" name="reason2"/> </td>
        </tr>
        <tr>
            <td colspan="2" align="right"><input type="submit"/> </td>
        </tr>
    </table>
</form>

</body>
</html>
