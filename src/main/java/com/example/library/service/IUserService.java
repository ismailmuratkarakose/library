package com.example.library.service;

import com.example.library.domain.User;

public interface IUserService {
	
	User getUserById(long id);

	User getUserByUsername(String username);

	User addUser(User user);

	Iterable<User> getUsers();

}
