package iot.core.services.helper;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shyzzle on 13/07/2017.
 */
public class ActionParser {

    public static SimpleAction parseUnencryptedCommand(String txt) {
        SimpleAction action = new SimpleAction();
        JSONObject json;
        try {
            json = new JSONObject(txt);

            action.setCommand((String) json.get("command"));
            action.setSensor((String) json.get("sensor"));
            action.setValue((String) json.get("value"));
        } catch (JSONException e) {
            System.out.println("Could not parse JSON: " + txt);
            action.setCommand("UNKNOWN");
        }

        return action;
    }

    public static ComplexAction parseComplexAction(String txt) {
        ComplexAction action = new ComplexAction();
        JSONObject json;

        try {

            json = new JSONObject(txt);
            JSONArray data = json.getJSONArray("data");
            List<SensorPair> list = new ArrayList<>();
            action.setCommand((String) json.get("command"));

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                SensorPair pair = new SensorPair();
                pair.setSensor(c.getString("sensor"));
                pair.setValue(c.getString("value"));
                list.add(pair);
            }

            action.setData(list);
        } catch (JSONException e) {
            System.out.println("Could not parse JSON: " + txt);
            action.setCommand("UNKNOWN");
        }

        return action;
    }
}
