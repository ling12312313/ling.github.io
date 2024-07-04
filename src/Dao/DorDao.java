package Dao;

import model.Dormitories;
import model.Student;
import model.Water;
import model.Work;
import utli.DaoUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DorDao {
    //由宿舍号查询的宿舍对象
    public Dormitories query_aDor(String id) throws SQLException, ClassNotFoundException {
        String sql = "select *from dormitories where dor_id = '"+id+"'";
        ResultSet resultSet = DaoUtils.query(sql);
        Dormitories dormitories = new Dormitories();
        if(resultSet!=null){
            while (resultSet.next()){
                dormitories.setDor_id(resultSet.getInt("dor_id"));
                dormitories.setDor_num(resultSet.getInt("dor_num"));
                dormitories.setDor_addr(resultSet.getString("dor_addr"));
                dormitories.setDor_node(resultSet.getString("dor_node"));
            }
        }
        return dormitories;
    }
    // 由宿舍号查询所有相同宿舍号的学生
    public LinkedList<Student> query_allStu(String id) throws SQLException, ClassNotFoundException {
        String sql = "select *from student where dor_id = '"+id+"'";
        ResultSet resultSet = DaoUtils.query(sql);
        LinkedList<Student> list = new LinkedList<>();
        Student student;
        if(resultSet!=null){
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
    //将work保存到服务器
    public boolean storeWork(Work work) throws SQLException, ClassNotFoundException {
        String sql =  "INSERT INTO work (dor_id, style, date, description, stu_id) " + "VALUES (" + work.getDor_id() + ", '" + work.getStyle() + "', '" + work.getDate() + "', '" + work.getDescription() + "', " + work.getStu_id() + ")";
                return DaoUtils.upData(sql);

    }
    //将water保存到服务器
    public boolean storeWater(Water water) throws SQLException, ClassNotFoundException {
        String sql ="insert into water (dor_id, water_num)"+"values("+water.getDor_id()+",'"+water.getWater_num()+"')";
            return DaoUtils.upData(sql);
    }
    //查询所有的宿舍
    public static LinkedList<Dormitories> queryAllDor() throws SQLException, ClassNotFoundException {
        String sql = "select *from dormitories";
         ResultSet resultSet =   DaoUtils.query(sql);
         LinkedList<Dormitories> list = new LinkedList<>();
         Dormitories dormitories;
         if(resultSet!=null){
             while (resultSet.next()){
                 dormitories = new Dormitories();
                 dormitories.setDor_id(resultSet.getInt("dor_id"));
                 dormitories.setDor_node(resultSet.getString("dor_node"));
                 dormitories.setDor_num(resultSet.getInt("dor_num"));
                 dormitories.setDor_addr(resultSet.getString("dor_addr"));
                list.add(dormitories);
             }
         }
         return list;
    }
    //由宿舍号查询所有事件work
    public static LinkedList<Work> dor_idQueryWork(int dor_id) throws SQLException, ClassNotFoundException {
         String sql ="select *from work where dor_id="+dor_id+"";
         ResultSet resultSet = DaoUtils.query(sql);
         LinkedList<Work> list = new LinkedList<>();
         Work work =null;
         if(resultSet!=null){
             while (resultSet.next()){
                 work = new Work();
                 work.setDate(resultSet.getString("date"));
                 work.setWork_id(resultSet.getInt("work_id"));
                 work.setDescription(resultSet.getString("description"));
                 work.setStyle(resultSet.getString("style"));
                 work.setStu_id(resultSet.getInt("stu_id"));
                 work.setDor_id(resultSet.getInt("dor_id"));
                 list.add(work);
             }
         }
        return list;
    }
    //由宿舍号查询所有事件water
    public static LinkedList<Water> dor_idQueryWater(int dor_id) throws SQLException, ClassNotFoundException {
        String sql ="select *from water where dor_id="+dor_id+"";
        ResultSet resultSet = DaoUtils.query(sql);
        LinkedList<Water> list = new LinkedList<>();
        Water water =null;
        if(resultSet!=null){
            while (resultSet.next()){
                water = new Water();
                water.setWater_id(resultSet.getInt("water_id"));
                water.setDor_id(resultSet.getInt("dor_id"));
                water.setWater_num(resultSet.getInt("water_num"));
                list.add(water);
            }
        }
        return list;
    }
    //通过water_id删除一个water
    public static boolean deleteWater(int water_id) throws SQLException, ClassNotFoundException {
        String sql = "delete from water where water_id="+water_id+"";
        return DaoUtils.upData(sql);
    }
    //通过work_id删除一个work
    public static boolean deleteWork(int work_id) throws SQLException, ClassNotFoundException {
        String sql = "delete from work where work_id="+work_id+"";
        return DaoUtils.upData(sql);
    }
}
