package com.example.library.service;

import java.util.List;

import com.example.library.domain.User;

public interface UserService {

	User getUserById(Long id);
	
	User getUserByEmail(String email);
	
	User addUser(User user);
	
	User updateUser(User user);

	List<User> getUsers();
	
	void deleteUser(User user);

}
