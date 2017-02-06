package iot.presentation.controllers;

import iot.core.services.interfaces.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String sayHello() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody JSONObject login(@RequestParam String name, @RequestParam String password) {
        JSONObject response = new JSONObject();

        if (userService.authenticateUser(name, password)) {
            // add token to session or something
        }

        return response;
    }

    @RequestMapping(value = "/loginTest")
    public
    @ResponseBody
    String sayHelloString() {
        return "Hello World dummy";
    }

}
