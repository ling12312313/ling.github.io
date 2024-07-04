package servlet.admin;

import Dao.DorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/completeEventServlet")
public class CompleteEventServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));
        if(action.equals("water")){
            boolean isSuccess = false;
            try {
                isSuccess =  DorDao.deleteWater(id);
                resp.setContentType("text/html; charset=UTF-8");
                resp.sendRedirect(req.getContextPath()+"/web/jsp/admin/index/dor/events.jsp?isSuccess="+isSuccess);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else if(action.equals("work")){
            boolean isSuccess = false;
            try {
                isSuccess = DorDao.deleteWork(id);
                resp.setContentType("text/html; charset=UTF-8");
                resp.sendRedirect(req.getContextPath()+"/web/jsp/admin/index/dor/events.jsp?isSuccess="+isSuccess);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
