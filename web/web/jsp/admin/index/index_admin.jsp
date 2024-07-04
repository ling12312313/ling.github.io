<%@ page import="model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/24
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="${pageContext.request.contextPath}/web/js/index/index.js"></script>
    <title>宿舍管理系统 - 管理员主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/admin/index/index_admin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/js/admin/index/to-class_admin.js"></script>
</head>
<body>
<%
    Admin admin = (Admin) request.getAttribute("admin");
    HttpSession session1 = request.getSession();
    session.setAttribute("admin", admin);
%>
<div class="container">
    <header class="header">
        <div class="logo">宿舍管理系统</div>
        <div class="user-info">
            <span>欢迎管理员: <%=admin.getAdmin_id()%>  </span>
            <a href="${pageContext.request.contextPath}/logoutServlet" class="logout" style="color: #cccccc">退出</a>
        </div>
    </header>

    <nav class="sidebar">
        <ul>
<%--            href="${pageContext.request.contextPath}/web/jsp/admin/index/class_admin.jsp"--%>
<%--    href="${pageContext.request.contextPath}/web/jsp/admin/index/stu_admin.jsp"--%>
<%--    href="${pageContext.request.contextPath}/web/jsp/admin/index/dor_admin.jsp"--%>
<%--    href="${pageContext.request.contextPath}/web/jsp/admin/index/other_admin.jsp"--%>
            <li><a onclick="loadImage()" id="tab1">首页</a></li>
            <li><a onclick="includeB('class_admin.jsp')"  id="tab2">班级信息</a></li>
            <li><a onclick="includeB('stu_admin.jsp')" id="tab3">学生信息</a></li>
            <li><a onclick="includeB('dor_admin.jsp')" id="tab4">宿舍信息</a></li>
            <li><a onclick="includeB('other_admin.jsp')" id="tab5">其他页面</a></li>
        </ul>
    </nav>

    <main id ="main-content" class="main-content">

    </main>

    <footer class="footer">
        <p>&copy; 2024 宿舍管理系统. 保留所有权利.</p>
    </footer>
</div>
</body>
</html>
