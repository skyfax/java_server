package iot.presentation.transport;

import java.util.List;

public class GroupDTO {

    private long id;
    private List<UserDTO> users;
    private List<DeviceDTO> devices;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<DeviceDTO> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceDTO> devices) {
        this.devices = devices;
    }
}
