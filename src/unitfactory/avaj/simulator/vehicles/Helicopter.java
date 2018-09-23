package unitfactory.avaj.simulator.vehicles;

import unitfactory.avaj.simulator.WeatherTower;
import unitfactory.avaj.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Helicopter (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int[][] coord = {{10,0,2},{5,0,0},{1,0,0},{0,0,-12}};
        String[] msg = {"This is hot.", "Rain", "Fog smell like strawberry","My rotor is going to freeze!"};
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
        this.file.setLog("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.\n");
    }
}
