package Data;

/**
 * country类
 */
public class Country {
    private String countryName;
    private String confirmed;
    private String recovered;
    private String deaths;
    private String location;
    private String capital_city;
    private String sq_km_area;

    public Country(){
    }

    public Country(String countryName, String confirmed, String recovered, String deaths, String location, String capital_city, String sq_km_area) {
        this.countryName = countryName;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.location = location;
        this.capital_city = capital_city;
        this.sq_km_area = sq_km_area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSq_km_area() {
        return sq_km_area;
    }

    public void setSq_km_area(String sq_km_area) {
        this.sq_km_area = sq_km_area;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public String getCapital_city() {
        return capital_city;
    }

    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", recovered='" + recovered + '\'' +
                ", deaths='" + deaths + '\'' +
                ", location='" + location + '\'' +
                ", capital_city='" + capital_city + '\'' +
                ", sq_km_area='" + sq_km_area + '\'' +
                '}';
    }
}
