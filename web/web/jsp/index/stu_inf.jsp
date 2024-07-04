<%@ page import="model.Student" %>
<%@ page import="model.Class2" %>
<%@ page import="Dao.ClassDao" %><%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/23
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生信息展示</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/index/stu_inf.css">
</head>
<body>
<%
    //从session中获得当前学生对象
    Student student = (Student) request.getSession().getAttribute("student");
    String class_id = String.valueOf(student.getClass_id());
    //通过班级id查询班级名称
    ClassDao classDao = new ClassDao();
    Class2 class2 = classDao.query_aStu(class_id);
    request.setAttribute("student",student);
%>
<div class="container">
    <h1>学生信息展示</h1>
    <table>
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>所属班级</th>
            <th>所在宿舍</th>
            <th>性别</th>
            <th>年龄</th>
        </tr>
        <tr>
            <td>${student.stu_id}</td>
            <td>${student.name}</td>
            <td><%=class2.getClass_name()%></td>
            <td>${student.dor_id}</td>
            <td>${student.gender}</td>
            <td>${student.age}</td>
        </tr>
    </table>
</div>
</body>
</html>
