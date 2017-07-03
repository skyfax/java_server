package iot.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iot.core.services.interfaces.UserService;
import iot.presentation.transport.UserDTO;
import net.minidev.json.JSONObject;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject login(@RequestParam String name, @RequestParam String password, HttpSession session) {
        JSONObject response = new JSONObject();

        UserDTO user = userService.authenticateUser(name, password);

        if (user != null) {
            response.put("status", "ok");
            response.put("userId", user.getUserId());
            response.put("username", user.getUsername());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("isAuthenticated", true);
        } else {
            response.put("status", "invalid");
        }

        return response;
    }

    @RequestMapping(value = "/logOut")
    public void sayHelloString(HttpSession session) {

        session.removeAttribute("userId");
        session.removeAttribute("username");
        session.removeAttribute("isAuthenticated");

    }

}
