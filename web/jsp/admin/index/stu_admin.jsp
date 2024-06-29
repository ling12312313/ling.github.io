<%@ page import="java.util.LinkedList" %>
<%@ page import="model.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/24
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/admin/index/student_admin.css">
</head>
<body>
<%
    //获得查询得到的学生
    boolean isSuccess = Boolean.parseBoolean(request.getParameter("isSuccess"));
    int currentPage =0;
    if(isSuccess) {
       currentPage = (int) request.getAttribute("currentPage");
        LinkedList<Student>[] list2 = (LinkedList<Student>[]) request.getSession().getAttribute("list2");
        int noOfPages =(list2.length-1)/7;
        if (list2.length==1){
           noOfPages =1;
        }else if((list2.length-1)%7!=0){
            noOfPages+=1;
        }
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("noOfPages",noOfPages);
    }
   LinkedList<Student> curList = (LinkedList<Student>) request.getAttribute("curList");
   request.setAttribute("curList",curList);
%>

<div class="container">
    <h1>学生管理</h1>
    <div>
        <form method="post" action="${pageContext.request.contextPath}/queryByTypeServlet">
            <input type="text" placeholder="学生姓名" name="name">
            <input type="text" placeholder="性别" name="gender">
            <input type="text" placeholder="班级" name="class">
            <input type="text" placeholder="所在宿舍" name="dor">
            <button type="submit">查询</button>
        </form>
    </div>
    <table>
        <thead>
        <tr>
            <th>学生姓名</th>
            <th>性别</th>
            <th>班级</th>
            <th>所在宿舍</th>
            <th>联系电话</th>
        </tr>
        </thead>
        <tbody>
          <c:forEach var="student" items="${curList}">
              <tr>
                  <td>${student.name}</td>
                  <td>${student.gender}</td>
                  <td>${student.class_name}</td>
                  <td>${student.dor_id}</td>
                  <td>${student.phone}</td>
              </tr>
          </c:forEach>
        </tbody>
    </table>
    <div class="pagination">
        <!-- 仅当当前页大于1时，显示首页和上一页按钮 -->
        <c:if test="${currentPage > 0}">
            <a href="${pageContext.request.contextPath}/upDownPageServlet?currentPage=0">首页</a>
            <a href="${pageContext.request.contextPath}/upDownPageServlet?currentPage=${currentPage - 1}">上一页</a>
        </c:if>
        <!-- 仅当当前页小于总页数时，显示下一页和尾页按钮 -->
        <c:if test="${currentPage+1 < noOfPages}">
            <a href="${pageContext.request.contextPath}/upDownPageServlet?currentPage=${currentPage + 1}">下一页</a>
            <a href="${pageContext.request.contextPath}/upDownPageServlet?currentPage=${noOfPages-1}">尾页</a>
        </c:if>
        <!-- 显示当前页和总页数 -->
        <span>页数 ${currentPage+1}/${noOfPages}</span>
    </div>
</div>
</body>
</html>
