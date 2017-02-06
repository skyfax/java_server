package iot.core.entities.sensor;

public enum SensorType {
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
}
