package Data;

/**
 * city类
 */
public class City {
    private String cityName;
    private String confirmed;
    private String recovered;
    private String deaths;

    public City(){
    }

    public City(String cityName, String confirmed, String recovered, String deaths) {
        this.cityName = cityName;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", recovered='" + recovered + '\'' +
                ", deaths='" + deaths + '\'' +
                '}';
    }
}
