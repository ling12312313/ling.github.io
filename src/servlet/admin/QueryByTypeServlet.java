package servlet.admin;

import Dao.StuDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

@WebServlet(urlPatterns = "/queryByTypeServlet")
public class QueryByTypeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String className = req.getParameter("class");
        String dor = req.getParameter("dor");
        StringBuilder sql = new StringBuilder("SELECT * FROM student s JOIN class c ON s.class_id = c.class_id WHERE 1=1");
        //用户输入的选择量个数
        LinkedList<String> conditions = new LinkedList<>();

        if (name != null && !name.isEmpty()) {
            sql.append(" AND s.name LIKE ?");
            conditions.add("%" + name + "%");
        }
        if (gender != null && !gender.isEmpty()) {
            sql.append(" AND s.gender = ?");
            conditions.add(gender);
        }
        if (className != null && !className.isEmpty()) {
            sql.append(" AND c.class_name = ?");
            conditions.add(className);
        }
        if (dor != null && !dor.isEmpty()) {
            sql.append(" AND s.dor_id = ?");
            conditions.add(dor);
        }

        if (conditions.isEmpty()) {
            // 用户一个都没选择输入，输出为空
            sql.append(" AND 1=0");
        }
        //调用Dao类执行查询，并返回结果
        StuDao stuDao = new StuDao();
        try {
            LinkedList<Student> list = stuDao.queryByType(String.valueOf(sql),conditions);
           if(list.size()==0) {req.getRequestDispatcher("/web/jsp/admin/index/stu_admin.jsp").forward(req,resp);}
                LinkedList<Student>[] list2 = upDownPage(list);
                req.setAttribute("list2",list2);
                HttpSession session = req.getSession();
                session.setAttribute("list2",list2);
                req.getRequestDispatcher("/upDownPageServlet?currentPage=0").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    protected  LinkedList<Student>[] upDownPage(LinkedList<Student> list){
        //拆分list
        int i=0,j=0;
        //最大初始化list2的长度;
        //假定list2的每个list长为7
        //即使你创建了一个 LinkedList<Student>[] 数组，数组中的每个元素（即每个 LinkedList<Student>）仍然是 null，除非你显式地对它们进行初始化。
        LinkedList<Student>[] list2 = (LinkedList<Student>[]) new LinkedList[list.size()];
        list2[0] = new LinkedList<Student>();
        if(!list.isEmpty()) {
            for (Student student : list) {
                i++;
                if (i < 8) {
                    list2[j].add(student);
                }
                //重置i;
                else {j++;
                    list2[j] = new LinkedList<>();
                i = 0;}
            }
        }
        return list2;
    }

}