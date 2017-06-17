package com.example.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.domain.User;
import com.example.library.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
