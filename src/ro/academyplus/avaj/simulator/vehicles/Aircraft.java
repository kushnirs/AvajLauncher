package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.weather.Coordinates;

public class Aircraft {
    protected long id;
    protected String type;
    protected String name;
    protected Coordinates coordinates;

    private static long idCounter;

    protected Aircraft( String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextid();

    }

    private long nextid() {
        return idCounter++;
    }

    private void update_coordinates(Coordinates coordinates, int longitude, int latitude, int height) {
        this.coordinates = new Coordinates(coordinates.getLongitude() + longitude,
                coordinates.getLatitude() + latitude,
                coordinates.getHeight() + height);
    }

    public void setType(String type) {
        this.type = type;
    }
}
