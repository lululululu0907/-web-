<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/5/24
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>申请证明</title>
    <script language="JavaScript" type="application/javascript">
        function backk() {
            window.history.back();
        }
    </script>
</head>
</div>
<div align="right">
    <input type="button" value="返回" onclick="backk()"/>
</div>
<body>
<ul>
    <c:forEach items="${list}" var="item">
        <li><a href="download?filename=${item}">${item}</a> </li>

    </c:forEach>
</ul>

</body>
</html>
