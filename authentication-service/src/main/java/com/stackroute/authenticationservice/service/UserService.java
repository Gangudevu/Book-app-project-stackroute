package com.stackroute.authenticationservice.service;

import com.stackroute.authenticationservice.exception.UserAlreadyExistsException;
import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.model.User;

public interface UserService {
	public User createUser(User user) throws UserAlreadyExistsException;

	public User updateUser(String id, User user);
	
	public User updateUserPassword(String id, String password);

	public void deleteUser(int id) throws UserNotFoundException;
	
	public User getUserByEmail(String email) throws UserNotFoundException;
	
	public User login(String email, String password) throws UserNotFoundException;
}
