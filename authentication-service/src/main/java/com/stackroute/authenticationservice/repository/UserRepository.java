package com.stackroute.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.authenticationservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailAndPassword(String email, String password);
	public User findByEmail(String email);
}
