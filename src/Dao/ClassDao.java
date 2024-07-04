package Dao;

import model.Class2;
import model.Student;
import utli.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ClassDao {
    //由班级号查询班级对象
    public Class2 query_aStu(String id) throws SQLException, ClassNotFoundException {
        String sql = "select *from class where class_id = '"+id+"'";
         ResultSet resultSet =  DaoUtils.query(sql);
        Class2 class2 = new Class2();
         if(resultSet!=null){
             while (resultSet.next()){
                 class2.setClass_id(resultSet.getInt("class_id"));
                 class2.setClass_name(resultSet.getString("class_name"));
             }
         }
         return class2 ;
    }

    //由班级号查询同一个班级号的所有学生
    public LinkedList<Student> query_allStu(String id) throws SQLException, ClassNotFoundException {
        String sql = "select *from student where class_id = '"+id+"'";
        ResultSet resultSet  = DaoUtils.query(sql);
        LinkedList<Student> list = new LinkedList<>();
        if(resultSet!=null){
            Student student;
            while (resultSet.next()){
                student = new Student();
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender"));
                student.setClass_id(resultSet.getInt("class_id"));
                student.setStu_id(resultSet.getInt("stu_id"));
                student.setDor_id(resultSet.getInt("dor_id"));
                student.setPassword(resultSet.getString("password"));
                student.setPhone(resultSet.getString("phone"));
                list.add(student);
            }
        }
        return list;
    }
    //查询所有班级
    public LinkedList<Class2> query_all() throws SQLException, ClassNotFoundException {
        String sql = "select *from class";
        ResultSet resultSet = DaoUtils.query(sql);
        LinkedList<Class2> classList = new LinkedList<>();
        Class2 class2;
        if(resultSet!=null){
            while (resultSet.next()){
                class2 = new Class2();
                class2.setClass_name(resultSet.getString("class_name"));
                class2.setClass_teacher(resultSet.getString("class_teacher"));
                class2.setClass_id(resultSet.getInt("class_id"));
                classList.add(class2);
            }
        }
        return classList;
    }
    //删除某个班级
    public boolean deleteClass(int class_id) throws SQLException, ClassNotFoundException {
        String sql = "delete from class where class_id='"+class_id+"'";
        return DaoUtils.upData(sql);
    }
    public boolean storeClass(Class2 class2) throws SQLException, ClassNotFoundException {
        String sql = "insert into class (class_name,class_teacher)"+"values('"+class2.getClass_name()+"','"+class2.getClass_teacher()+"')";
        return DaoUtils.upData(sql);
    }

}
