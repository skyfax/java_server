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

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String sayHello() {
		return "login";
	}

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public @ResponseBody JSONObject login(@RequestParam String name, @RequestParam String password) {
		JSONObject response = new JSONObject();

		String token = "asdasd.test";
		String token_type = "jwt";
		int expires_in = 7200;

		// UserDTO user = userService.authenticateUser(name, password);
		UserDTO user = new UserDTO();
		user.setUserId(1);

		if (user != null) {
			response.put("token", token);
			response.put("token_type", token_type);
			response.put("expires_in", expires_in);
			response.put("user_id", user.getUserId());
		}

		return response;
	}

	@RequestMapping(value = "/loginTest")
	public @ResponseBody String sayHelloString() {
		return "Hello World dummy";
	}

}
