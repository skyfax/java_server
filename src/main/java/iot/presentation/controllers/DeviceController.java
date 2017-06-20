package iot.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iot.core.services.interfaces.DeviceService;
import iot.presentation.transport.DeviceDTO;
import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	DeviceService deviceService;

	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	public @ResponseBody Boolean addDevice(@RequestBody DeviceDTO device) {

		device.setId(null);
		// TODO get user id from session
		long userId = 1;
		return Boolean.valueOf(deviceService.addDevice(device, userId));
	}

	@RequestMapping(value = "/{deviceId}", method = RequestMethod.GET)
	public @ResponseBody JSONObject getDevice(@RequestParam long deviceId) {
		JSONObject object = new JSONObject();
		DeviceDTO dev = deviceService.getDeviceById(deviceId);

		object.put("device", dev);

		return object;
	}

	@RequestMapping(value = "/removeDevice", method = RequestMethod.POST)
	public @ResponseBody Boolean removeDevice(@RequestParam long deviceId) {

		return Boolean.valueOf(deviceService.removeDevice(deviceId));
	}

	@RequestMapping(value = "/getDevices", method = RequestMethod.POST)
	public @ResponseBody JSONObject getDevices() {
		JSONObject response = new JSONObject();

		/// TODO add session and getUser id from there
		long userId = 1;
		List<DeviceDTO> devices = deviceService.getUserDevices(userId);

		response.put("devices", devices);

		return response;
	}

	@RequestMapping(value = "/editDevice", method = RequestMethod.POST)
	public @ResponseBody Boolean editDevice(@RequestBody DeviceDTO device) {

		return Boolean.valueOf(deviceService.editDevice(device));
	}

}
