<%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/21
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宿舍管理系统 - 修改密码</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/js/RePassword.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/RePassword.css">
</head>
<body>
<div class="container">
    <div class="change-password-box">
        <h1>宿舍管理系统</h1>
        <h2>修改密码</h2>
        <form action="${pageContext.request.contextPath}/rePasswordServlet" method="POST" onsubmit=" return validateForm()">
            <div class="textbox">
                <select name="user_type" required>
                    <option value="" disabled selected>选择身份</option>
                    <option value="student">学生</option>
                    <option value="admin">管理员</option>
                </select>
            </div>
            <div class="textbox">
                <input type="text" placeholder="学生(工号)" name="current_user_id" required>
            </div>
            <div class="textbox">
                <input type="password" placeholder="当前密码" name="current_password" required>
            </div>
            <div class="textbox">
                <input type="password" placeholder="新密码" id = "new_password" name="new_password" required>
            </div>
            <div class="textbox">
                <input type="password" placeholder="确认新密码" id = "confirm_password" name="confirm_password" required>
            </div>
            <input type="submit" class="btn" value="修改密码">
        </form>
    </div>
</div>
<%
    String isSuccess = request.getParameter("isSuccess");
    if (isSuccess != null) {
        out.println("<script type='text/javascript'>handleResponse('" + isSuccess + "');</script>");
    }
%>
</body>
</html>



