<%@ page import="model.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/13
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<%--    <script src="${pageContext.request.contextPath}/web/js/index/ajax.js"></script>--%>
    <script src="${pageContext.request.contextPath}/web/js/index/index.js"></script>
    <script src="${pageContext.request.contextPath}/web/js/index/to-class.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>宿舍管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/index/user_index.css">

</head>
<body>
<%  Student student = (Student) request.getAttribute("student");
      //将student存放在session中
    HttpSession session1 = request.getSession();
    session1.setAttribute("student",student);
%>
<div class="container">
    <header class="header">
        <div class="logo">宿舍管理系统</div>
        <div class="user-info">
            <span>欢迎您: <%=student.getName()%>  </span>
            <a href="${pageContext.request.contextPath}/logoutServlet" class="logout" style="color: #cccccc">退出</a>
        </div>
    </header>

    <nav class="sidebar">
        <ul>
<%--            ${pageContext.request.contextPath}/web/jsp/index/class_inf.jsp"--%>
            <li><a onclick="loadImage()" id="tab1">首页</a></li>
            <li><a onclick="includeB('class_inf.jsp')" id="tab2" >班级信息</a></li>
            <li><a onclick="includeB('stu_inf.jsp')" id ="tab3">学生信息</a></li>
            <li><a onclick="includeB('dor_manage.jsp')" id="tab4" >宿舍信息</a> </li>
            <li><a onclick="includeB('other.jsp')">其他页面</a></li>
        </ul>
    </nav>

    <main  id="main-content" class="main-content">
<%--      <img src="${pageContext.request.contextPath}/web/image/img.png" width="1300" height="600" alt="这是一张图片">--%>
    </main>

    <footer class="footer">
        <p>&copy; 2024 宿舍管理系统. 保留所有权利.</p>
    </footer>
</div>
</body>
</html>
