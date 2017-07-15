package iot.core.services.helper;

import net.minidev.json.JSONObject;

/**
 * Created by Shyzzle on 13/07/2017.
 */
public class SimpleAction extends Action{

    private String command;
    private String sensor;
    private String value;


    public String getCommand() {
        return command;
    }

    public SimpleAction setCommand(String command) {
        this.command = command;

        return this;
    }

    public String getSensor() {
        return sensor;
    }

    public SimpleAction setSensor(String sensor) {
        this.sensor = sensor;

        return this;
    }

    public String getValue() {
        return value;
    }

    public SimpleAction setValue(String value) {
        this.value = value;
        return this;
    }

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("command", command);
        obj.put("sensor", sensor);
        obj.put("value", value);

        return obj;
    }
}
