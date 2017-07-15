package iot.presentation.controllers;

import iot.core.services.interfaces.UserService;
import iot.presentation.transport.UserDTO;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ResponseEntity<Boolean> registerAccount(@RequestBody UserDTO sentUser) {

		UserDTO savedUser = userService.addUser(sentUser);

		return new ResponseEntity<>(savedUser != null, HttpStatus.OK);
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ResponseEntity<Boolean> editAccount(@RequestBody UserDTO sentUser) {

		boolean wasSuccessful = userService.editUser(sentUser);

		return new ResponseEntity<>(wasSuccessful, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public JSONObject getUser(@RequestParam long userId) {
		JSONObject response = new JSONObject();
		UserDTO user = userService.getUser(userId);

		if (user != null) {
			response.put("user", user);
			response.put("status", "ok");
		} else {
			response.put("status", "fail");
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE)
	public JSONObject deleteUser(@RequestParam long userId) {
		JSONObject response = new JSONObject();

		if (userService.removeUser(userId)) {
			response.put("status", "ok");
		} else {
			response.put("status", "fail");
		}
		return response;
	}

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

}
