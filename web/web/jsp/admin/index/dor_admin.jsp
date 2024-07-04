<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/24
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="model.Dormitories" %>
<%@ page import="Dao.DorDao" %>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/admin/index/dor_admin.css">
    <script type="text/javascript">
        function viewEvents(dor_id) {
            window.location.href ="${pageContext.request.contextPath}/web/jsp/admin/index/dor/events.jsp?dor_id="+dor_id+"&is=true";
        }
    </script>
</head>
<body>
<div class="container">
    <h1>所有宿舍信息</h1>
    <%
        LinkedList<Dormitories> list = DorDao.queryAllDor();
        request.setAttribute("list", list);
    %>
    <c:forEach items="${list}" var="dorm">
        <div class="dorm">
            <h3>${dorm.dor_id}</h3>
            <p>人数: ${dorm.dor_num}</p>
            <p>地址: ${dorm.dor_addr}</p>
            <button onclick="viewEvents(${dorm.dor_id})">查看事件</button>
        </div>
    </c:forEach>
</div>
</body>
</html>

