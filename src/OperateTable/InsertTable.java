package OperateTable;

import CreateTable.DBUtils;
import Data.City;
import Data.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable {
    /**
     * t_city表的insert操作
     * @param city
     */
    public void insertCity(City city){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            String sql = "insert into t_city(cityName,confirmed,recovered,deaths) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,city.getCityName());
            ps.setString(2,city.getConfirmed());
            ps.setString(3,city.getRecovered());
            ps.setString(4,city.getDeaths());

            int count = ps.executeUpdate();
            if(count == 1){
                System.out.println(city.getCityName() + "城市" + "插入t_city表成功");
            }else{
                System.out.println("插入t_city表失败");
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
            DBUtils.close(conn,ps);
        }
    }

    /**
     * t_country表的insert操作
     * @param country
     */
    public void insertCountry(Country country){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            String sql = "insert into t_country(countryName,confirmed,recovered,deaths,location,capital_city,sq_km_area) values(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,country.getCountryName());
            ps.setString(2,country.getConfirmed());
            ps.setString(3,country.getRecovered());
            ps.setString(4,country.getDeaths());
            ps.setString(5,country.getLocation());
            ps.setString(6,country.getCapital_city());
            ps.setString(7,country.getSq_km_area());

            int count = ps.executeUpdate();
            if(count == 1){
                System.out.println("插入t_country表成功");
            }else{
                System.out.println("插入t_country表失败");
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
            DBUtils.close(conn,ps);
        }
    }
}
