package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.simulator.Logger;
import ro.academyplus.avaj.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weathertower);
    public void setLogFile(Logger file);
}
