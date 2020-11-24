package com.stackroute.recommendationservice.service;

import com.stackroute.recommendationservice.exception.UserAlreadyExistsException;
import com.stackroute.recommendationservice.exception.UserNotFoundException;
import com.stackroute.recommendationservice.model.User;

public interface UserService {
	public User createUser(User user) throws UserAlreadyExistsException;

	public User updateUser(String id, User user);
	
	public User updateUserPassword(String id, String password);

	public void deleteUser(int id) throws UserNotFoundException;
	
	public User getUserByEmail(String email) throws UserNotFoundException;
	
	public User login(String email, String password) throws UserNotFoundException;
}
