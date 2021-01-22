package ConstructByJSON;

import Data.Country;
import GetJSON.GetJSONFromAPI;
import OperateTable.InsertTable;
import OperateTable.QueryTable;
import OperateTable.UpdateTable;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static OperateTable.QueryTable.ifCountryExist;

/**
 * 得到Country的json对象，转为Java的Country对象
 */
public class ConstructCountry {
    private InsertTable insertTable = new InsertTable();
    private UpdateTable updateTable = new UpdateTable();
    static Map<String,Integer> countries = new HashMap<>();
    static{
        countries.put("China",1);
        countries.put("US",2);
        countries.put("United Kingdom",3);
        countries.put("Japen",4);
    }

    public String getCountryJson(String countryName){
        GetJSONFromAPI getJSONFromAPI = new GetJSONFromAPI();
        String url = "https://covid-api.mmediagroup.fr/v1/cases?country="+countryName;
        return getJSONFromAPI.getJson(url);
    }

    /**
     * 根据国家名获取这个国家的总数据
     * @param   countryName
     * @return  country
     */
    public Country constructCountryByJson(String countryName){
        String json = getCountryJson(countryName);
        JSONObject jsonObject = new JSONObject(json);
        JSONObject o = new JSONObject(jsonObject.getString("All"));
        return new Country(countryName,o.getString("confirmed"), o.getString("recovered"),
                o.getString("deaths"), o.getString("location"),
                o.getString("capital_city"),o.getString("sq_km_area")
        );
    }

    public void insertAllCountry(){
        Iterator it = countries.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            String countryName = (String) entry.getKey();
            Country country = constructCountryByJson(countryName);
            insertCountry(country);
        }
    }

    public void insertCountry(Country country) {
        boolean check = ifCountryExist; //该国家是否已在表中
        if(check == false){ //若该国家不存在表中，则插入表中
            insertTable.insertCountry(country);
        }else{ //若存在，则更新数据
            Country newCountry = constructCountryByJson(country.getCountryName());
            updateTable.updateCountry(newCountry);
        }
    }

}
