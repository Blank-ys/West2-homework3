package ConstructByJSON;

import Data.City;
import Data.Country;
import OperateTable.QueryTable;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 得到city的json对象，转为Java的City对象
 */
public class ConstructCity {
    private static ConstructCountry constructCountry = new ConstructCountry();
    private static QueryTable queryTable = new QueryTable();

    public City getCityWeb(Country country,String cityName){
        String countryJson = constructCountry.getCountryJson(country.getCountryName());
        JSONObject jsonObject = new JSONObject(countryJson);
        JSONObject o = new JSONObject(jsonObject.getString(cityName));
        return getCityByJson(country,o,cityName);
    }

    /**
     * 得到一个国家的所有城市
     * @param   country
     * @return  cities
     */
    public List<City> getAllCity(Country country){
        List<City> cities = new ArrayList<>();
        String countryJson = constructCountry.getCountryJson(country.getCountryName());
        JSONObject jsonObject = new JSONObject(countryJson);
        Iterator it = jsonObject.keys();
        while(it.hasNext()){
            String cityName = (String) it.next();
            if("All".equals(cityName)) continue;
            String str = jsonObject.getString(cityName);
            JSONObject o = new JSONObject(str);
            cities.add(getCityByJson(country,o,cityName));
        }
        return cities;
    }

    public City getCityByJson(Country country,JSONObject o,String cityName){
        return new City(cityName,o.getString("confirmed"),
                o.getString("recovered"),o.getString("deaths")
        );
    }

}
