package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.User;
import com.example.library.domain.UserDTO;
import com.example.library.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<User> getAll() {
		return userService.getUsers();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody UserDTO request) {
		try {
			userService.deleteUser(userService.getUserByEmail(request.getEmail()));
			return "SUCCESS";
		} catch (Exception e) {
			return "FAIL";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User add(@RequestBody UserDTO request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setLastName(request.getLastName());
		user.setPhone(request.getPhone());
		user.setType(request.getType());
		user = userService.addUser(user);
		return user;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User update(@RequestBody UserDTO request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setLastName(request.getLastName());
		user.setPhone(request.getPhone());
		user.setType(request.getType());
		user = userService.updateUser(user);
		return user;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public User get(@RequestBody UserDTO request) {
			return userService.getUserByEmail(request.getEmail());
	}
}
