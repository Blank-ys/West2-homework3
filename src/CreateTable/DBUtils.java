package CreateTable;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.lang.module.Configuration;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * JDBC工具类，简化JDBC编程。
 */
public class DBUtils {
    //使用资源绑定器绑定
    static ResourceBundle bundle = ResourceBundle.getBundle("root");
    static String driver = bundle.getString("driver");
    static String url = bundle.getString("url");
    static String user = bundle.getString("user");
    static String password = bundle.getString("password");

    /**
     * 工具类中的构造方法都是私有的。
     * 因为工具类当中的方法都是静态的，不需要new对象，直接采用类名调用。
     */
    private DBUtils(){
    }

    //静态代码块在类加载时执行，并且只执行一次。
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *获取数据库操作对象
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        //return dataSource.getConnection();
        return DriverManager.getConnection(url, user,password);
    }


    /**
     *关闭资源
     * @param conn 连接对象
     * @param ps   数据库操作对象
     * @param rs   结果集
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     * @param conn  连接对象
     * @param ps    数据库操作对象
     */
    public static void close(Connection conn, Statement ps){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
