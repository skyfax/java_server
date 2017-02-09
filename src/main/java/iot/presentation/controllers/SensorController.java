package iot.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iot.core.services.interfaces.SensorService;
import iot.presentation.transport.SensorDTO;
import iot.presentation.transport.SensorValueDTO;
import net.minidev.json.JSONObject;

@Controller
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
	SensorService sensorService;

	@ResponseBody
	@RequestMapping(value = "/{sensorId}", method = RequestMethod.GET)
	public JSONObject getSensor(@RequestParam long sensorId) {
		JSONObject object = new JSONObject();
		SensorDTO sensor = sensorService.getSensorById(sensorId);

		object.put("sensor", sensor);

		return object;
	}

	@ResponseBody
	@RequestMapping(value = "/addSensor", method = RequestMethod.POST)
	public Boolean addSensor(@RequestBody SensorDTO sensor) {
		Boolean result = sensorService.addSensor(sensor);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/removeSensor", method = RequestMethod.POST)
	public Boolean removeSensor(@RequestParam long sensorId) {

		Boolean result = sensorService.removeSensor(sensorId);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/editSensor", method = RequestMethod.POST)
	public Boolean removeSensor(@RequestBody SensorDTO sensor) {

		Boolean result = sensorService.editSensor(sensor);

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addSensorValue", method = RequestMethod.POST)
	public Boolean addSensorValue(@RequestBody SensorValueDTO sensorValue) {

		Boolean result = sensorService.addSensorValue(sensorValue);

		return result;
	}

}
