package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.LinkedList;

@WebServlet(urlPatterns = "/upDownPageServlet")
public class UpDownPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取需要跳转到的页数
            int currentPage = Integer.parseInt(req.getParameter("currentPage"));
            LinkedList<Student>[] list2 = (LinkedList<Student>[]) req.getSession().getAttribute("list2");
            LinkedList<Student> curList = list2[currentPage];
            req.setAttribute("curList",curList);
            req.setAttribute("currentPage",currentPage);
            req.getRequestDispatcher("/web/jsp/admin/index/stu_admin.jsp?isSuccess=true").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
