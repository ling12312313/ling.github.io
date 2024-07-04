package Dao;

import model.Admin;
import model.Student;
import utli.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
        //查询学生
   public static Student query_stu(int  stu_id, String password) throws SQLException, ClassNotFoundException {
           String sql= "select * from student where stu_id = '"+stu_id+"' and password='"+password+"'";
           ResultSet resultSet = DaoUtils.query(sql);
           if (resultSet==null)return null;
           Student student =null;
           while (resultSet.next()) {
                   student = new Student();
                   student.setName(resultSet.getString("name"));
                   student.setAge(resultSet.getInt("age"));
                   student.setGender(resultSet.getString("gender"));
                   student.setClass_id(resultSet.getInt("class_id"));
                   student.setStu_id(resultSet.getInt("stu_id"));
                   student.setDor_id(resultSet.getInt("dor_id"));
                   student.setPassword(resultSet.getString("password"));
                   student.setPhone(resultSet.getString("phone"));
           }
           return student;
   }
   //查询管理员
   public static Admin query_adm(int id , String password) throws SQLException, ClassNotFoundException {
           String sql = "select *from admin where admin_id="+id+" and password ='"+password+"'";
           ResultSet resultSet = DaoUtils.query(sql);
           Admin admin=null;
           if(resultSet!=null){
                   while (resultSet.next()){
                           admin = new Admin();
                           admin.setAdmin_id(resultSet.getInt("admin_id"));
                           admin.setPassword(resultSet.getString("password"));
                   }
           }
           return admin;
   }
//   修改学生或管理员密码
        public static boolean modify_user(String sql,String sql2) throws SQLException, ClassNotFoundException {
            if(DaoUtils.query(sql)!=null){
               if (DaoUtils.upData(sql2)){
                   return true;
               };
            }return false;
           //查询账号信息是否正确
                // 正确修改
                //错误返回
        }


}
