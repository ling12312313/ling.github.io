package Dao;

import model.Student;
import utli.DaoUtils;
import utli.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class StuDao {
    public static ResultSet query(String sql,LinkedList<String> conditions) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        for (int i = 0; i < conditions.size(); i++) {
            preparedStatement.setString(i + 1, conditions.get(i));
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public LinkedList<Student> queryByType(String sql,LinkedList<String> conditions) throws SQLException, ClassNotFoundException {
       //该查询较为不同需要调用重写的query方法
        ResultSet resultSet =query(sql,conditions);
        LinkedList<Student> list = new LinkedList<>();
        Student student;
        if(resultSet!=null){
            while (resultSet.next()){
                student = new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender"));
                student.setClass_id(resultSet.getInt("class_id"));
                student.setClass_name(resultSet.getString("class_name"));
                student.setStu_id(resultSet.getInt("stu_id"));
                student.setDor_id(resultSet.getInt("dor_id"));
                student.setPassword(resultSet.getString("password"));
                student.setPhone(resultSet.getString("phone"));
                list.add(student);
            }
        }
        return list;
    }
}
