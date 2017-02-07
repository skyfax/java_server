package iot.presentation.controllers;

import iot.core.services.interfaces.GroupService;
import iot.presentation.transport.DeviceDTO;
import iot.presentation.transport.GroupDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;
    
    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public @ResponseBody Boolean addDevice(@RequestBody GroupDTO group){

//        return Boolean.valueOf(groupService.));
    	
    	return null;
    }
    
}
