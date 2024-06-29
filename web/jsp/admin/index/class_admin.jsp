<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="model.Class2" %>
<%@ page import="Dao.ClassDao" %><%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/24
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    ClassDao classDao = new ClassDao();
    LinkedList<Class2> classList = classDao.query_all();
    request.setAttribute("classList", classList);
%>
<head>
    <meta charset="UTF-8">
    <title>班级管理</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/js/admin/index/class/delete.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/admin/index/class_admin.css">
</head>
<body>
<div class="container">
    <div class="header">
        <button class="btn" onclick="addClass()">添加班级</button>
    </div>
    <table class="class-table">
        <thead>
        <tr>
            <th>班级编号</th>
            <th>班级名称</th>
            <th>带班老师</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="classTableBody">
        <c:forEach var="class2" items="${classList}">
            <tr>
                <td>${class2.class_id}</td>
                <td>${class2.class_name}</td>
                <td>${class2.class_teacher}</td>
                <td><button class="btn" onclick="confirmDelete(${class2.class_id})">删除班级</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%--判断是否删除成功--%>
<%
    String isSuccess = request.getParameter("isSuccess");
    if (isSuccess != null) {
        out.println("<script type='text/javascript'>handleResponse('" + isSuccess + "');</script>");
    }
%>
<script>
    function addClass() {
        // 跳转到添加班级的jsp
        window.location.href="${pageContext.request.contextPath}/web/jsp/admin/index/class/addClass.jsp";
    }

    function confirmDelete(class_id) {
        if (confirm('确定要删除这个班级吗？')) {
            deleteClass(class_id);
        }
    }

    function deleteClass(class_id) {
        // 跳转到 deleteClassServlet.servlet，并传递班级ID
        window.location.href = "${pageContext.request.contextPath}/deleteClassServlet?class_id=" + class_id;
    }
</script>
</body>
</html>



