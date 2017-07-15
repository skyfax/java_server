package iot.core.services.helper;

import java.util.List;

/**
 * Created by Shyzzle on 13/07/2017.
 */
public class ComplexAction extends Action{

    private String command;
    private List<SensorPair> data;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<SensorPair> getData() {
        return data;
    }

    public void setData(List<SensorPair> data) {
        this.data = data;
    }
}
