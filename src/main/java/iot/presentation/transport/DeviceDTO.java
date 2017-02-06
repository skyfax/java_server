package iot.presentation.transport;

public class DeviceDTO {

    private long id;
    private int dataFrequency;
    private String name;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDataFrequency() {
        return dataFrequency;
    }

    public void setDataFrequency(int dataFrequency) {
        this.dataFrequency = dataFrequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
