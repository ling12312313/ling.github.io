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
    <title>宿舍管理系统 - 登录</title>
    <link rel="stylesheet" href="../css/login_password.css">
</head>
<body>
<div class="container">
    <div class="login-box">
        <h1>宿舍管理系统</h1>
        <h2>登录</h2>
        <form action="${pageContext.request.contextPath}/loginServlet" method="POST">
            <div class="select-container">
                <span>选择登录类型:</span>
                <div class="user-type-toggle">
                    <input type="radio" id="student" name="userType" value="student" checked>
                    <label for="student" class="toggle-option">学生</label>
                    <input type="radio" id="admin" name="userType" value="admin">
                    <label for="admin" class="toggle-option">管理员</label>
                </div>
            </div>
            <div class="textbox">
                <input type="text" placeholder="学号/工号" name="stu_id" value="${cookie.stu_id.value}" required>
            </div>
            <div class="textbox">
                <input type="password" placeholder="密码" name="password" required>
            </div>
            <input type="submit" class="btn" value="登录">
        </form>
        <div class="link-container">
            <a href="change_password.jsp">忘记密码？</a>
        </div>
    </div>
</div>
</body>
</html>



