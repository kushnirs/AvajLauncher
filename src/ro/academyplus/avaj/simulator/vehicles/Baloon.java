package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.simulator.WeatherTower;
import ro.academyplus.avaj.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        weatherTower.getWeather(coordinates);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
