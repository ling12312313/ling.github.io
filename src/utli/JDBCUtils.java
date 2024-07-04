package utli;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public final  class JDBCUtils {
    private static String driverClass;
    private static String url;
    private static String useName;
    private static String password;
    private static Connection connection;
    static {
        try { //配置信息
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");
            Properties pre = new Properties();
            pre.load(is);
            driverClass = pre.getProperty("driverClass");
            url = pre.getProperty("url");
            useName = pre.getProperty("useName");
            password = pre.getProperty("password");
            Class.forName(driverClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url,useName,password);
        return connection;
    }
    public static Statement getStatement() throws SQLException {
        Statement statement = connection.createStatement();
        return  statement;
    }
    public static void close(Connection con,Statement sta,ResultSet resu) {
        if (con != null){
            try{
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if(sta!=null)
                try {
                    sta.close();
                }catch (SQLException e){
                    throw new RuntimeException(e);
                }
            if (resu!=null)
                try {
                    resu.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }
    }
    public static void close(Connection connection,Statement statement){
        close(connection,statement,null);
    }
}
