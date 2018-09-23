package unitfactory.avaj.simulator.MyException;

public class AmountParameterException extends Exception{
    private int line;
    public AmountParameterException(int line) {
        this.line = line;
    }

    public String getMsg() {
        return "Wrong amount of parameters in line " + line;
    }
}
