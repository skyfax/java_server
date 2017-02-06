package iot.presentation.controllers;

import iot.core.services.interfaces.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;
}
