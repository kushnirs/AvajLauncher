package ro.academyplus.avaj.weather;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"} ;

    private WeatherProvider () { }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates) {
        int index = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        return weather[index % 4];
    }
}
