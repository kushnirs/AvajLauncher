package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.simulator.WeatherTower;
import ro.academyplus.avaj.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int[][] coord = {{2,0,4},{0,0,-5},{0,0,-3},{0,0,-15}};
        String[] msg = {"Let's enjoy the good weather and take some pics.", "Damn you rain! You messed up my baloon.", "Fog is sucks.","It's snowing. We're  gonna crash."};
        int res = update_coordinates(weatherTower.getWeather(coordinates), coord, msg);

        if (res == 0) {
            this.weatherTower.unregister(this);
            this.file.setLog("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.\n" +
                    "Current coordinate:\n" +
                    "Longtitude: " + coordinates.getLongitude() +
                    "\nLatitude: " + coordinates.getLatitude() +
                    "\nHeight: " + coordinates.getHeight() + "\n");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        this.file.setLog("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.\n");
    }
}
