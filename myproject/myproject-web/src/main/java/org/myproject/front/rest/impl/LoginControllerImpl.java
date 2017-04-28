package org.myproject.front.rest.impl;

import org.myproject.front.rest.LoginController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = "http://localhost:8100")
public class LoginControllerImpl implements LoginController {
	@RequestMapping("/users")
	@Override
	public @ResponseBody String getUsers() {
		return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"},"
				+ "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
	}

}
