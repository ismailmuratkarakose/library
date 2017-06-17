package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}