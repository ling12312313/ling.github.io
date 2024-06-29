<%@ page import="java.util.LinkedList" %>
<%@ page import="model.Water" %>
<%@ page import="Dao.DorDao" %>
<%@ page import="model.Work" %><%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/25
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>宿舍事件</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/admin/index/dor/events.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/web/js/admin/index/dor/complete.js"></script>
</head>
<body>
<div class="container">
    <h2>宿舍事件</h2>
    <%
        int dor_id=0;
        String is  =request.getParameter("is");
        //判断是否是第一次进入该jsp
        if(is!=null) {
            dor_id = Integer.parseInt(request.getParameter("dor_id"));
            HttpSession session1 = request.getSession();
            session1.setAttribute("dor_id", dor_id);
        }else {
            dor_id = (int) request.getSession().getAttribute("dor_id");
        }
        LinkedList<Water> listWater = DorDao.dor_idQueryWater(dor_id);
        LinkedList<Work> listWork = DorDao.dor_idQueryWork(dor_id);
        request.setAttribute("listWater",listWater);
        request.setAttribute("listWork",listWork);
    %>
    <div class="event">
        <table><thead>
        <tr>
            <th>购水单</th>
            <th>宿舍号</th>
            <th>事件号</th>
            <th>数量</th>
            <th>操作</th>
        </tr>
        </thead>
            <tbody>
            <c:forEach items="${listWater}" var="event">
                <tr>
                    <td></td>
                    <td>${event.dor_id}</td>
                    <td>${event.water_id}</td>
                    <td>${event.water_num}</td>
                    <td><button onclick="completeEvent(${event.water_id},'water')">完成</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table><thead>
        <tr>
            <th>报修单</th>
            <th>宿舍号</th>
            <th>事件号</th>
            <th>类型</th>
            <th>时间</th>
            <th>描述</th>
            <th>学号</th>
        </tr>
        </thead>
            <tbody>
            <c:forEach items="${listWork}" var="event">
                <tr>
                    <td></td>
                    <td>${event.dor_id}</td>
                    <td>${event.work_id}</td>
                    <td>${event.style}</td>
                    <td>${event.date}</td>
                    <td>${event.description}</td>
                    <td>${event.stu_id}</td>
                    <td><button onclick="completeEvent(${event.work_id},'work')">完成</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    function completeEvent(id,action) {
        // 实现完成事件的逻辑
        window.location.href="${pageContext.request.contextPath}/completeEventServlet?action="+action+"&id="+id+"";
    }
</script>
<%--判断是否删除成功--%>
<%
    String isSuccess = request.getParameter("isSuccess");
    if (isSuccess != null) {
        out.println("<script type='text/javascript'>handleResponse('" + isSuccess + "');</script>");
    }
%>
</body>
</html>
