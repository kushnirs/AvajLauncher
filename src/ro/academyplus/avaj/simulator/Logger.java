package ro.academyplus.avaj.simulator;

import java.io.*;

public class Logger {
    protected File file;
    protected FileWriter fr;

    public Logger(String path) {
        try {
            file = new File(path);
            file.createNewFile();
            fr = new FileWriter(file, false);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public void setLog(String msg) {
        try {
            fr.write(msg);
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public void closeLog() {
        try {
            fr.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
