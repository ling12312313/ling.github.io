package servlet;

import Dao.DorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;
import model.Work;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(urlPatterns = "/repairServlet")
public class RepairServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dor_id = Integer.parseInt(req.getParameter("dor_id"));
        String style = req.getParameter("style");
        String date = (req.getParameter("date"));
        String description = req.getParameter("description");
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");
        int stu_id = student.getStu_id();
        Work work = new Work(stu_id,dor_id,style,date,description);
        DorDao dorDao = new DorDao();
        try {
            boolean isSuccess = dorDao.storeWork(work);
            resp.setContentType("text/html; charset=UTF-8");
            resp.sendRedirect(req.getContextPath()+"/web/jsp/index/dor/repair.jsp?isSuccess="+isSuccess);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
