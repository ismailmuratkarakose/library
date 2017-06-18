package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.domain.User;

public interface IUserRepository extends CrudRepository<User, Long> {
	User getUserByEmail(String email);
}