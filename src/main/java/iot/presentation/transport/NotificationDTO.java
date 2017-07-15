package iot.presentation.transport;

import net.minidev.json.JSONObject;

/**
 * Created by Shyzzle on 11/07/2017.
 */
public class NotificationDTO {

    private Long userId;
    private String sensor;
    private String value;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String convertToJson(){
        JSONObject obj = new JSONObject();
        obj.put("sensor",sensor);
        obj.put("value", value);

        return obj.toJSONString();
    }

}
