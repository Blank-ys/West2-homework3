package OperateTable;

import CreateTable.DBUtils;
import Data.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
    /**
     *t_city表的update操作
     * @param sql
     */
    public void updateCity(String sql){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DBUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            if(count == 1){
                System.out.println("修改t_city表成功");
            }else{
                System.out.println("修改t_city表失败");
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
        }finally{
            DBUtils.close(conn,stmt);
        }
    }

    /**
     *t_country表的update操作
     * @param country
     */
    public void updateCountry(Country country){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            String sql = "update t_country set confirmed = ?,recovered = ?,deaths = ?," +
                    "location = ?,capital_city = ?,sq_km_area = ? where countryName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,country.getConfirmed());
            ps.setString(2,country.getRecovered());
            ps.setString(3,country.getDeaths());
            ps.setString(4,country.getLocation());
            ps.setString(5,country.getCapital_city());
            ps.setString(6,country.getSq_km_area());
            ps.setString(7,country.getCountryName());

            int count = ps.executeUpdate();
            if(count == 1){
                System.out.println("修改t_country表成功");
            }else{
                System.out.println("修改t_country表失败");
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
        }finally{
            DBUtils.close(conn,ps);
        }

    }
}
