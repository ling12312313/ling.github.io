package servlet;

import Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/rePasswordServlet")
public class RePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String current_user_id = req.getParameter("current_user_id");
        String current_password = req.getParameter("current_password");
        String confirm_password = req.getParameter("confirm_password");
        String userType = req.getParameter("user_type");
        StringBuilder sql = new StringBuilder("select *from ");
        String sql2 ="";
        if (userType.equals("student")){
            sql.append("student where stu_id = '"+current_user_id+"'and password='"+current_password+"'" );
            sql2 = "update student set password='"+confirm_password+"' where stu_id ='"+current_user_id+"'";
        }else if(userType.equals("admin")){
            sql.append("admin where admin_id = '"+current_user_id+"'and password='"+current_password+"'" );
            sql2 = "update admin set password='"+confirm_password+"' where admin_id='"+current_user_id+"'";
        }
        try {
           boolean isSuccess =  UserDao.modify_user(String.valueOf(sql),sql2);
            resp.setContentType("text/html; charset=UTF-8");
            resp.sendRedirect(req.getContextPath()+"/web/jsp/change_password.jsp?isSuccess="+isSuccess);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
