package servlet;

import Dao.DorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Water;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/buyWaterServlet")
public class BuyWaterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int dor_id = Integer.parseInt(req.getParameter("dormitory"));
        int water_num = Integer.parseInt(req.getParameter("quantity"));
        Water water = new Water(dor_id,water_num);
        DorDao dorDao = new DorDao();
        try {
            boolean isSuccess = dorDao.storeWater(water);
            resp.setContentType("text/html; charset=UTF-8");
            resp.sendRedirect(req.getContextPath()+"/web/jsp/index/dor/buyWater.jsp?isSuccess="+isSuccess);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
