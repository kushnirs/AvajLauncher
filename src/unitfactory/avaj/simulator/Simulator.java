package unitfactory.avaj.simulator;

import unitfactory.avaj.simulator.MyException.AmountParameterException;
import unitfactory.avaj.simulator.MyException.WrongCoordException;
import unitfactory.avaj.simulator.MyException.WrongTypeException;
import unitfactory.avaj.simulator.vehicles.AircraftFactory;
import unitfactory.avaj.simulator.vehicles.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static WeatherTower weatherTower;
    private static Logger file = new Logger("simulation.txt");
    private static List<Flyable> flyables = new ArrayList<Flyable>();

    public static void main(String[] arg) {
        try {
            int count = 0;
            if (arg.length != 1)
                throw new IOException("Wrong amount of argument");
            BufferedReader reader = new BufferedReader((new FileReader(arg[0])));
            String line = reader.readLine();
            count++;
            if (line != null) {
                weatherTower = new WeatherTower();
                String[] param = line.split(" ");
                if (param.length != 1)
                    throw new AmountParameterException(count);
                int simulations = Integer.parseInt(param[0]);
                if (simulations < 0) {
                    System.out.println("Invalid simulation count" + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    count++;
                    param = line.split(" ");
                    if (param.length != 5)
                        throw new AmountParameterException(count);
                    Flyable flyable = AircraftFactory.newAircraft(param[0],
                            param[1],
                            Integer.parseInt(param[2]),
                            Integer.parseInt(param[3]),
                            Integer.parseInt(param[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.setLogFile(file);
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
                file.closeLog();
            }
        } catch (WrongCoordException e) {
            System.out.println(e.getMsg());
        } catch (WrongTypeException e) {
            System.out.println(e.getMsg());
        } catch (AmountParameterException e) {
            System.out.println(e.getMsg());
        } catch (NumberFormatException e) {
            System.out.println("Some parameter is't number");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
