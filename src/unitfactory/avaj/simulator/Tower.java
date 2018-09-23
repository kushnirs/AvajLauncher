package unitfactory.avaj.simulator;

import unitfactory.avaj.simulator.vehicles.Flyable;
import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observes = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        observes.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observes.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observes.size(); i++)
            observes.get(i).updateConditions();
    }
}
