package CreateTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 在数据库中创建t_country表和t_city表
 */
public class Table {
    public static void main(String[] args) {

        // 创建t_country表
        String sql1 = "create table t_country("
                + "countryName varchar(255),"
                + "confirmed varchar(255),"
                + "recovered varchar(255),"
                + "deaths varchar(255),"
                + "sq_km_area varchar(255),"
                + "location varchar(255),"
                + "capital_city varchar(255)"
                + ");";

        //创建city表
        String sql2 = "create table t_city("
                + "cityName varchar(255),"
                + "confirmed varchar(255),"
                + "recovered varchar(255),"
                + "deaths varchar(255)"
                + ");";

        Connection conn = null;
        Statement stmt1 = null;
        Statement stmt2 = null;
        try {
            //获取连接
            conn = DBUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            //获取数据库操作对象
            stmt1 = conn.createStatement();
            stmt2 = conn.createStatement();

            int count1 = stmt1.executeUpdate(sql1);
            if(count1 == 0){
                System.out.println("创建t_country表成功");
            }else{
                System.out.println("创建t_country表失败");
            }

            int count2 = stmt2.executeUpdate(sql2);
            if(count2 == 0){
                System.out.println("创建t_city表成功");
            }else{
                System.out.println("创建t_city表失败");
            }

            //提交事务（事务的结束）
            conn.commit();
        } catch (SQLException e) {
            if(conn != null){
                try {
                    //回滚事务（事务结束）
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtils.close(conn,stmt1);
            DBUtils.close(conn,stmt2);
        }

    }
}
