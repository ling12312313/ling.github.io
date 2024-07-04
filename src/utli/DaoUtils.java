package utli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtils {
    //数据库操作只有更新和查询俩种大类的操作，所以，可以提取Dao中重复的操作作为一个工具类
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static  ResultSet resultSet = null;
    private static int resul=0;

    public static ResultSet query(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = JDBCUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public static  boolean upData(String sql) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = JDBCUtils.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resul = preparedStatement.executeUpdate();
        if(resul==0)
            return false;
        return true;
    }
}
