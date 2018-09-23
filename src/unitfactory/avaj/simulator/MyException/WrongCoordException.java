package unitfactory.avaj.simulator.MyException;

public class WrongCoordException extends Exception {
    private String type;
    public WrongCoordException() { }

    public String getMsg() {
        return "Coordinate must be > 0";
    }
}
