package servlet;

import Dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import model.Student;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static Dao.UserDao.query_adm;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用Dao，检查user信息是否正确
        int  id = Integer.parseInt(req.getParameter("stu_id"));
        String password = req.getParameter("password");
        String userType = req.getParameter("userType");
        //根据用户类型调用不同的数据库查询方法
        if (userType.equals("student")){
            student_fun(id,password,req,resp);
        }
        else if(userType.equals("admin")){
             admin_fun(id,password,req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    protected void student_fun(int id,String password,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
            Student student=null;
            try {
                student = UserDao.query_stu(id,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            if (student!=null) {
                //设置cookie免学号登录
                Cookie cookie =  new Cookie("id",id+"");
                //设置cookie最大存活时间
                // cookie.setMaxAge(60*60*24*7);
                resp.addCookie(cookie);
                req.setAttribute("student",student);
                req.getRequestDispatcher("/web/jsp/index/index_test.jsp").forward(req, resp);
            }else {
                resp.setContentType("text/html;charset-utf-8");
                //获得流
                PrintWriter out = resp.getWriter();
                out.println("学号(工号)或密码错误,3秒重新登录");
                //密码错误，删除cookie
                Cookie[] cookies = req.getCookies();
                for(Cookie cookie:cookies){
                    if(cookie.getValue().equals(id))
                        cookie.setMaxAge(0);
                }
                resp.setHeader("Refresh",3+";"+req.getContextPath()+"/web/jsp/login.jsp");
            }
        }
    protected void admin_fun(int id,String password,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
       Admin admin = null;
        try {
            admin = UserDao.query_adm(id,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (admin!=null) {
            //设置cookie免学号登录
            Cookie cookie =  new Cookie("id",id+"");
            //设置cookie最大存活时间
            // cookie.setMaxAge(60*60*24*7);
            resp.addCookie(cookie);
            req.setAttribute("admin",admin);
            req.getRequestDispatcher("/web/jsp/admin/index/index_admin.jsp").forward(req, resp);
        }else {
            resp.setContentType("text/html;charset-utf-8");
            //获得流
            PrintWriter out = resp.getWriter();
            out.println("学号(工号)或密码错误,3秒重新登录");
            //密码错误，删除cookie
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie:cookies){
                if(cookie.getValue().equals(id))
                    cookie.setMaxAge(0);
            }
            resp.setHeader("Refresh",3+";"+req.getContextPath()+"/web/jsp/login.jsp");
        }
    }


}