package unitfactory.avaj.simulator.vehicles;

import unitfactory.avaj.simulator.MyException.WrongCoordException;
import unitfactory.avaj.simulator.MyException.WrongTypeException;
import unitfactory.avaj.weather.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
            throws WrongTypeException, WrongCoordException {

        if (longitude < 0 || latitude < 0 || height <= 0)
            throw new WrongCoordException();
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
        else if (type.compareTo("Helicopter") == 0){
            tmp = new Helicopter(name, coord);
            ((Helicopter) tmp).setType(type);
        }
        else
            throw new WrongTypeException(type);
        return tmp;
    }
}
