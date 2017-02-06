package iot.presentation.controllers;

import iot.core.services.interfaces.DeviceService;
import iot.presentation.transport.DeviceDTO;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/addDevice", method = RequestMethod.POST)
    public @ResponseBody Boolean addDevice(@RequestBody DeviceDTO device){

        return Boolean.valueOf(deviceService.addDevice(device));
    }

    @RequestMapping(value = "/{deviceId}", method = RequestMethod.GET)
    public @ResponseBody
    JSONObject getDevice(@RequestParam long deviceId){
        JSONObject object = new JSONObject();
       DeviceDTO dev =  deviceService.getDeviceById(deviceId);

       object.put("device",dev);

       return object;
    }



}
