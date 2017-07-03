package iot.presentation.controllers;

import iot.utils.AuthUtils;
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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sensor")
public class SensorController {

	@Autowired
	SensorService sensorService;

	@ResponseBody
	@RequestMapping(value = "/{sensorId}", method = RequestMethod.GET)
	public JSONObject getSensor(@RequestParam long sensorId, HttpSession session) {
		JSONObject object = new JSONObject();
		SensorDTO sensor = sensorService.getSensorById(sensorId);

		object.put("sensor", sensor);

		return object;
	}

	@ResponseBody
	@RequestMapping(value = "/addSensor", method = RequestMethod.POST)
	public JSONObject addSensor(@RequestBody SensorDTO sensor, HttpSession session) {
		JSONObject obj = new JSONObject();

		if(AuthUtils.isUserAuthenticated(session)){
			sensor.setId(null);
			Boolean result = sensorService.addSensor(sensor);
			obj.put("statusText", result?"success":"error");
		}

		return obj;
	}

	@ResponseBody
	@RequestMapping(value = "/removeSensor", method = RequestMethod.POST)
	public JSONObject removeSensor(@RequestParam long sensorId, HttpSession session) {
		JSONObject obj = new JSONObject();
		if(AuthUtils.isUserAuthenticated(session)){
			Boolean result = sensorService.removeSensor(sensorId);

			obj.put("statusText", result);
		}


		return obj;
	}

	@ResponseBody
	@RequestMapping(value = "/editSensor", method = RequestMethod.POST)
	public Boolean removeSensor(@RequestBody SensorDTO sensor, HttpSession session) {
		Boolean result = false;

		if(AuthUtils.isUserAuthenticated(session)){
			 result = sensorService.editSensor(sensor);
		}

		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addSensorValue", method = RequestMethod.POST)
	public Boolean addSensorValue(@RequestBody SensorValueDTO sensorValue, HttpSession session) {

		Boolean result = sensorService.addSensorValue(sensorValue);

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getSensorData", method = RequestMethod.POST)
	public JSONObject addSensor(@RequestParam long sensorId, HttpSession session) {
		JSONObject jsonObject = new JSONObject();
		List<SensorValueDTO> sensorValues= sensorService.getSensorValues(sensorId);
		jsonObject.put("values",sensorValues);

		return jsonObject;
	}

}
