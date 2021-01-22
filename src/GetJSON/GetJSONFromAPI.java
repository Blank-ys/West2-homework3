package GetJSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 将json取出转为Java对象
 */
public class GetJSONFromAPI {
    public static void main(String[] args) {
        GetJSONFromAPI getJSONFromAPI = new GetJSONFromAPI();
        String json = getJSONFromAPI.getJson("https://covid-api.mmediagroup.fr/v1/cases?country=China");
        System.out.println(json);
    }

    public String getJson(String url){
        url = url.replaceAll(" ", "%20");
        StringBuilder json = new StringBuilder();
        try{
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null){
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}