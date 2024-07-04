package servlet.admin;

import Dao.ClassDao;
import Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/deleteClassServlet")
public class DeleteClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int class_id = Integer.parseInt(req.getParameter("class_id"));
        ClassDao classDao = new ClassDao();
        try {
            boolean isSuccess = classDao.deleteClass(class_id);
            resp.setContentType("text/html; charset=UTF-8");
            resp.sendRedirect(req.getContextPath()+"/web/jsp/admin/index/class_admin.jsp?isSuccess="+isSuccess);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
