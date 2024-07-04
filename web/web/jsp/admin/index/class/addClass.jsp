<%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/24
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/js/admin/index/class/add.js"> </script>
    <title>添加班级信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/admin/index/class/add.css">
</head>
<body>
<h2>添加班级</h2>
<form action="${pageContext.request.contextPath}/addClassServlet" method="post">
    <label for="className">班级名称：</label>
    <input type="text" id="className" name="class_name" required>
    <br><br>
    <label for="classTeacher">班主任：</label>
    <input type="text" id="classTeacher" name="class_teacher" required>
    <br><br>
    <input type="submit" value="添加班级">
</form>
<%
    String isSuccess = request.getParameter("isSuccess");
    if (isSuccess != null) {
        out.println("<script type='text/javascript'>handleResponse('" + isSuccess + "');</script>");
    }
%>
</body>
</html>

