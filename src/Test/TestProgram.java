package Test;

import ConstructByJSON.ConstructCity;
import ConstructByJSON.ConstructCountry;
import Data.City;
import Data.Country;
import GetJSON.GetJSONFromAPI;
import OperateTable.InsertTable;
import OperateTable.QueryTable;
import OperateTable.UpdateTable;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProgram {
    static List<String> countries = new ArrayList<>();
    static{
        countries.add("China");
        countries.add("US");
        countries.add("United Kingdom");
        countries.add("Japan");
    }
    private static ConstructCity constructCity= new ConstructCity();
    private static ConstructCountry constructCountry = new ConstructCountry();
    private static InsertTable insertTable = new InsertTable();
    private static QueryTable queryTable = new QueryTable();
    private static UpdateTable updateTable = new UpdateTable();

    /**
     * 该主方法提供了一个简单的查询国家信息的测试程序
     * 测试程序之后的代码为这个项目里部分方法的测试，请删除注释后进行测试
     * @param args
     */
    public static void main(String[] args) {
        //通过用户输入国家的序号查询国家的信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入国家序号来获取该国家的疫情数据(All)");
        System.out.println("1.China");
        System.out.println("2.US");
        System.out.println("3.United Kingdom");
        System.out.println("4.Japan");
        System.out.println("输入'exit'终止此测试功能");
        while(sc.hasNext()){
            String input = sc.next();
            if("exit".equals(input)) break;
            switch (input){
                case "1":
                    queryTable.queryCountry("China");
                    break;
                case "2":
                    queryTable.queryCountry("US");
                    break;
                case "3":
                    queryTable.queryCountry("United Kingdom");
                    break;
                case "4":
                    queryTable.queryCountry("Japan");
                    break;
                default:
                    System.out.println("输入错误或没有当前国家信息，请重新输入!");
            }
        }

        //从API中get4个国家的总数据(All+cities)(仅供功能测试使用)
        /*
        for(int i = 0 ; i < countries.size() ; i++){
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            Country country = constructCountry.constructCountryByJson(countries.get(i));
            System.out.println(country.toString());
            List<City> cities = constructCity.getAllCity(country);
            for(int j = 0 ; j < cities.size() ; j++){
                City city = cities.get(j);
                System.out.println(city.toString());
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
        }
         */

        //将API里所有国家的数据(All)保存到数据库的t_country表中(仅供功能测试使用)
        /*
        for(int i = 0 ; i < countries.size() ; i++){
            String countryName = countries.get(i);
            queryTable.queryCountry(countryName);
            Country country = constructCountry.constructCountryByJson(countryName);
            insertTable.insertCountry(country);
        }
         */

        //将API里所有city的数据保存到数据库的t_city表中(仅供功能测试使用)
        /*
        for(int i = 0 ; i < countries.size() ; i++){
            Country country = constructCountry.constructCountryByJson(countries.get(i));
            constructCity.getAllCity(country);
            List<City> cities = constructCity.getAllCity(country);
            for(int j = 0 ; j < cities.size() ; j++){
                City city = cities.get(j);
                insertTable.insertCity(city);
            }
        }
         */

        //从数据库中查询每个国家的信息(All)(仅供功能测试使用)
        /*
        for(int i = 0 ; i < countries.size() ; i++){
            String countryName = countries.get(i);
            queryTable.queryCountry(countryName);
        }
         */

        //得到城市“北京”的数据(仅供功能测试使用)
        /*
        Country country = constructCountry.constructCountryByJson(countries.get(0));
        City city = constructCity.getCityWeb(country,"Beijing");
        System.out.println(city.toString());
         */
    }
}
