<%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/22
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍购买水</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/js/dor_manage/buyWater_submit.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/index/dor/buyWater.css">
</head>
<body>
<div class="container">
    <h2>宿舍购买水</h2>
    <form method="post" action="${pageContext.request.contextPath}/buyWaterServlet">
        <div class="form-group">
            <label for="dormitory">宿舍：</label>
            <input type="text" id="dormitory" name="dormitory" value="${sessionScope.get("student").dor_id}" required>
        </div>
        <div class="form-group">
            <label for="quantity">购买数量：</label>
            <input type="number" id="quantity" name="quantity" required>
        </div>
        <div class="form-group">
            <button type="submit" name="purchase">购买</button>
        </div>
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
