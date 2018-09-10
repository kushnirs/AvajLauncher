package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.simulator.Logger;
import ro.academyplus.avaj.weather.Coordinates;

public class Aircraft {
    protected long id;
    protected Logger file;
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
        return ++idCounter;
    }

    protected int update_coordinates(String weather, int[][] coord, String[] msg) {
        int i = 0;

        if (weather.compareTo("SUN") == 0)
            i = 0;
        else if(weather.compareTo("RAIN") == 0)
            i = 1;
        else if(weather.compareTo("FOG") == 0)
            i = 2;
        else if(weather.compareTo("SNOW") == 0)
            i = 3;

        file.setLog(this.type + "#" + this.name + "(" + this.id + "): " + msg[i] + ".\n");
        if ((this.coordinates.getHeight() + coord[i][2]) <= 0)
            return 0;
        this.coordinates = new Coordinates(this.coordinates.getLongitude() + coord[i][0],
                this.coordinates.getLatitude() + coord[i][1],
                this.coordinates.getHeight() + coord[i][2]);
        return 1;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLogFile(Logger file) {
        this.file = file;
    }
}
