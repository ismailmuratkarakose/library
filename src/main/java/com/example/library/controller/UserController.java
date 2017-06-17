package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.User;
import com.example.library.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/anan")
	public User a() {
		User user = new User("userasdsad", "passasdsadsad");
		user.setName("sadasdasd");
		user.setLastName("sadassadsadd");
		return userService.addUser(user);
	} 
	
}
