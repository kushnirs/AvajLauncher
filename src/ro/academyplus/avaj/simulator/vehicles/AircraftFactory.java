package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.weather.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

        Coordinates coord = new Coordinates(longitude, latitude, height);
        Flyable tmp;
        if (type.compareTo("Baloon") == 0) {
            tmp = new Baloon(name, coord);
            ((Baloon) tmp).setType(type);
        }
        else if (type.compareTo("JetPlane") == 0) {
            tmp = new JetPlane(name, coord);
            ((JetPlane) tmp).setType(type);
        }
        else {
            tmp = new Helicopter(name, coord);
            ((Helicopter) tmp).setType(type);
        }
        return tmp;
    }
}
