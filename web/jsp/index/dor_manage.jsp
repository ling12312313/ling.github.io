<%@ page import="model.Student" %>
<%@ page import="model.Dormitories" %>
<%@ page import="utli.DaoUtils" %>
<%@ page import="Dao.DorDao" %><%--
  Created by IntelliJ IDEA.
  User: 20121
  Date: 2024/6/21
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍信息查询系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/index/dor_manage.css">
</head>
<body>
<%
     //获取该学生所在的宿舍对象
    Student student = (Student) request.getSession().getAttribute("student");
    String dor_id = String.valueOf(student.getDor_id());
    DorDao dorDao = new DorDao();
    Dormitories dormitories = dorDao.query_aDor(dor_id);
%>
<div class="header">
    <h1>宿舍信息查询系统</h1>
</div>
<div class="content">
    <form>
    <table class="dormitory-table">
        <thead>
        <tr>
            <th>宿舍编号</th>
            <th>宿舍地址</th>
            <th>已住人数</th>
            <th>宿舍备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><%=dormitories.getDor_id()%></td>
                <td><%=dormitories.getDor_addr()%></td>
                <td><%=dormitories.getDor_num()%></td>
                <td><%=dormitories.getDor_node()%></td>
                    <%--                id 用于js脚本，单击该按钮后启动模态窗口--%>
                <td>
                    <input type="button" class="detail-btn" value="详情" id="openModalBtn">
                     <%--                绑定脚本跳转到指定界面--%>
                    <input type="button" class="repair-btn" value="报修" onclick="redirectToTargetPage()">

                    <input type="button" class="buy-btn" value="买水" onclick="buyWater()">
                </td>
            </tr>
        </tbody>
    </table>
    </form>
</div>
<div class="footer">
    <p>版权信息</p>
</div>
<div id="modalContainer"></div>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/dor_manage/buyWater.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/dor_manage/repair.js"></script>
<script src="${pageContext.request.contextPath}/web/js/dor_manage/detail.js"></script>
</body>
</html>