package iot.presentation.controllers;

import java.util.List;

import iot.utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import iot.core.services.interfaces.DeviceService;
import iot.presentation.transport.DeviceDTO;
import net.minidev.json.JSONObject;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/device")
@SessionAttributes("user")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/addDevice", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject addDevice(@RequestBody DeviceDTO device, HttpSession session) {
        JSONObject obj = new JSONObject();

        if (AuthUtils.isUserAuthenticated(session)) {
            Long userId = AuthUtils.getUserId(session);
            device.setId(null);
            Boolean response = deviceService.addDevice(device, userId);
            obj.put("statusText", response);
        }


        return obj;
    }

    @RequestMapping(value = "/{deviceId}", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject getDevice(@RequestParam long deviceId, HttpSession session) {
        JSONObject object = new JSONObject();

        if (AuthUtils.isUserAuthenticated(session)) {
            DeviceDTO dev = deviceService.getDeviceById(deviceId);
            object.put("device", dev);
        }

        return object;
    }

    @RequestMapping(value = "/removeDevice", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject removeDevice(@RequestParam long deviceId, HttpSession session) {
        JSONObject obj = new JSONObject();

        if (AuthUtils.isUserAuthenticated(session)) {
            Long userId = AuthUtils.getUserId(session);
            obj.put("statusText", deviceService.removeDevice(deviceId));
        }

        return obj;
    }

    @RequestMapping(value = "/getDevices", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject getDevices(HttpSession session) {
        JSONObject response = new JSONObject();

        if (AuthUtils.isUserAuthenticated(session)) {
            Long userId = AuthUtils.getUserId(session);
            List<DeviceDTO> devices = deviceService.getUserDevices(userId);
            response.put("status", "ok");
            response.put("devices", devices);
        } else {
            response.put("status", "error");
        }

        return response;
    }

    @RequestMapping(value = "/editDevice", method = RequestMethod.POST)
    public @ResponseBody
    Boolean editDevice(@RequestBody DeviceDTO device, HttpSession session) {
        boolean response = false;

        if (AuthUtils.isUserAuthenticated(session)) {
            response = deviceService.editDevice(device);
        }

        return response;
    }

}
