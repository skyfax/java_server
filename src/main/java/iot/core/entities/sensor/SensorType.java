package iot.core.entities.sensor;

public enum SensorType {
    UNDEFINED(0),
    HUMIDITY(1),
    PRESSURE(2),
    TEMPERATURE(3);

    private final int value;

    private SensorType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static SensorType getSensorType(int type) {
        switch (type) {
            case 1:
                return HUMIDITY;
            case 2:
                return PRESSURE;
            case 3:
                return TEMPERATURE;
            default:
                return UNDEFINED;
        }

    }
}
