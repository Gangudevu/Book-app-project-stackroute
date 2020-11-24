package com.stackroute.recommendationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.recommendationservice.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmailAndPassword(String email, String password);
	public User findByEmail(String email);
}
