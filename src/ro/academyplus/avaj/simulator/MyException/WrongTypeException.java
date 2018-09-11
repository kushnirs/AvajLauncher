package ro.academyplus.avaj.simulator.MyException;

public class WrongTypeException extends Exception {
    private String type;
    public WrongTypeException(String type) {
        this.type = type;
    }

    public String getMsg() {
        return type + " doesn't exist";
    }
}
