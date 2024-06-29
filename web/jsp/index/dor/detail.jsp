<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Student" %>
<%@ page import="Dao.DorDao" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/21
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>模态窗口页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/web/css/index/dor/detail.css">
</head>
<body>
<%
  //根据当前学生宿舍号，查询所有与该宿舍号相同的学生信息
    Student student = (Student) request.getSession().getAttribute("student");
    String dor_id = String.valueOf(student.getDor_id());
    DorDao dorDao = new DorDao();
    LinkedList<Student> list = dorDao.query_allStu(dor_id);
    request.setAttribute("list",list);
%>

<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="closeBtn">&times;</span>
        <h2>宿舍信息</h2>
        <table>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>电话</th>
            </tr>
            <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.stu_id}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.phone}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
