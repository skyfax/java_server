package iot.common;

import java.util.ArrayList;
import java.util.List;

import iot.core.entities.device.Device;
import iot.presentation.transport.DeviceDTO;

/**
 * Created by Usera on 04/02/2017.
 */
public class DeviceConverter {

	public static DeviceDTO toDeviceDTO(Device device) {
		DeviceDTO d = new DeviceDTO();

		d.setDataFrequency(device.getDataFrequency());
		d.setId(device.getId());
		d.setName(device.getName());
		d.setToken(device.getToken());
		d.setSensors(SensorConverter.toSensorDTOList(device.getSensors()));

		return d;
	}

	public static List<DeviceDTO> toDeviceDTOList(List<Device> devices) {
		List<DeviceDTO> devs = new ArrayList<>();

		for (Device d : devices) {
			devs.add(toDeviceDTO(d));
		}

		return devs;
	}

}
