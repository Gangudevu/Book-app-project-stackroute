package com.stackroute.favouriteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.favouriteservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailAndPassword(String email, String password);
	public User findByEmail(String email);
}
