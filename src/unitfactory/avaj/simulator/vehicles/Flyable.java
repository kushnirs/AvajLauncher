package unitfactory.avaj.simulator.vehicles;

import unitfactory.avaj.simulator.Logger;
import unitfactory.avaj.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weathertower);
    public void setLogFile(Logger file);
}
