package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.simulator.WeatherTower;
import ro.academyplus.avaj.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane (String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        int[][] coord = {{0,10,2},{0,5,0},{0,1,0},{0,0,-7}};
        String[] msg = {"Sun is beautiful.", "It's raining. Better watch out for lightings.", "Fog is coming.","OMG! Winter is coming!"};
        int res = update_coordinates(weatherTower.getWeather(coordinates), coord, msg);

        if (res == 0) {
            this.weatherTower.unregister(this);
            this.file.setLog("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.\n" +
                    "Current coordinate:\n" +
                    "Longtitude: " + coordinates.getLongitude() +
                    "\nLatitude: " + coordinates.getLatitude() +
                    "\nHeight: " + coordinates.getHeight() + "\n");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        this.file.setLog("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.\n");
    }
}
