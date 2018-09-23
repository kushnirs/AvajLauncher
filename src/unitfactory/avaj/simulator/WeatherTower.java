package unitfactory.avaj.simulator;

import unitfactory.avaj.weather.Coordinates;
import unitfactory.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public WeatherTower() {}

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        conditionsChanged();
    }
}
