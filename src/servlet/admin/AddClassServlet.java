package servlet.admin;

import Dao.ClassDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Class2;
import utli.DaoUtils;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/addClassServlet")
public class AddClassServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String class_name = req.getParameter("class_name");
        String class_teacher = req.getParameter("class_teacher");
        Class2 class2 = new Class2(class_name,class_teacher);
        ClassDao classDao = new ClassDao();
        try {
           boolean isSuccess =  classDao.storeClass(class2);
            resp.setContentType("text/html; charset=UTF-8");
            resp.sendRedirect(req.getContextPath()+"/web/jsp/admin/index/class/addClass.jsp?isSuccess="+isSuccess);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
