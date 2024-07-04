<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/22
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍管理</title>
   <script type="text/javascript" src="${pageContext.request.contextPath}/web/js/dor_manage/repair_submit.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/index/dor/repair.css">
</head>
<body>
<%
//   获取当前时间
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss ");
    Date date = new Date(System.currentTimeMillis());
    request.setAttribute("date",formatter.format(date));
%>
<div class="container">
    <h2>宿舍管理———报修</h2>
    <form action="${pageContext.request.contextPath}/repairServlet?date=${date}" method="post">
        <div class="form-group">
            <label for="dor_id">宿舍名称</label>
            <input type="text" id="dor_id" name="dor_id" value="${sessionScope.get("student").dor_id}" placeholder="请输入名称">
        </div>
        <div class="form-group">
            <label for="style">报修类型</label>
            <select id="style" name="style">
                <option value="">请选择</option>
                <option value="门">门</option>
                <option value="窗">窗</option>
                <option value="桌">桌</option>
                <option value="锁">锁</option>
                <option value="水">水</option>
                <option value="电">电</option>
                <option value="厕所">厕所</option>
                <option value="下水道">下水道</option>
                <option value="其他">其他(详情描述)</option>
            </select>
        </div>
        <div class="form-group">
            <label >报修时间</label>
            ${date}
        </div>
        <div class="form-group">
            <label for="description">描述</label>
            <textarea id="description" name="description" placeholder="请输入描述"></textarea>
        </div>
        <button type="submit">提交</button>
    </form>
</div>

<%
    String isSuccess = request.getParameter("isSuccess");
    if (isSuccess != null) {
        out.println("<script type='text/javascript'>handleResponse('" + isSuccess + "');</script>");
    }
%>
</body>
</html>
