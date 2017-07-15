package iot.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import iot.core.services.interfaces.GroupService;
import iot.presentation.transport.GroupDTO;

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

    private void toBeDeleted(){
        long id = 0;

        groupService.addDeviceToGroup(id,id,id);
        groupService.addGroup(new GroupDTO());
        groupService.addUserToGroup(id,id,id);
        groupService.removeDeviceFromGroup(id,id,id);
        groupService.removeGroup(id,id);
        groupService.removeUserFromGroup(id,id,id);
        groupService.getGroupById(id,id);
        groupService.getGroupList(id);
        groupService.getGroupDevices(id);
    }

}
