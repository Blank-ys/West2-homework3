package OperateTable;

import CreateTable.DBUtils;
import Data.City;
import Data.Country;

import java.sql.*;

public class QueryTable {
    public static boolean ifCountryExist = false;  //判断是否存在表中

    /**
     * t_country表的查询操作
     * @param countryName
     */
    public void queryCountry(String countryName){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            //String sql1 = "select * from t_country";
            String sql = "select * from t_country where countryName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,countryName); //通过国家名查找信息

            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(countryName + "已存在表中");
                ifCountryExist = true;

                String coName = countryName;

                String confirmed = rs.getString("confirmed");

                String recovered = rs.getString("recovered");

                String deaths = rs.getString("deaths");

                String sq_km_area = rs.getString("sq_km_area");

                String location = rs.getString("location");

                String capital_city = rs.getString("capital_city");

                System.out.println("Country{" +
                        "countryName='" + coName + '\'' +
                        ", confirmed='" + confirmed + '\'' +
                        ", recovered='" + recovered + '\'' +
                        ", deaths='" + deaths + '\'' +
                        ", location='" + location + '\'' +
                        ", capital_city='" + capital_city + '\'' +
                        ", sq_km_area='" + sq_km_area + '\'' +
                        '}');
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
            DBUtils.close(conn,ps,rs);
        }
    }

    /**
     *t_city表的查询操作
     * @param cityName
     */
    public void queryCity(String cityName){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            String sql = "select * from t_city where cityName = ?";
            ps.setString(1,cityName);
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()){
                String ciName = rs.getString("cityName");

                String confirmed = rs.getString("confirmed");

                String recovered = rs.getString("recovered");

                String deaths = rs.getString("deaths");

                System.out.println("City{" +
                        "cityName='" + cityName + '\'' +
                        ", confirmed='" + confirmed + '\'' +
                        ", recovered='" + recovered + '\'' +
                        ", deaths='" + deaths + '\'' +
                        '}');
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
            DBUtils.close(conn,ps,rs);
        }
    }
}
