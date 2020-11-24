package com.stackroute.favouriteservice.service;

import com.stackroute.favouriteservice.exception.UserAlreadyExistsException;
import com.stackroute.favouriteservice.exception.UserNotFoundException;
import com.stackroute.favouriteservice.model.User;

public interface UserService {
	public User createUser(User user) throws UserAlreadyExistsException;

	public User updateUser(String id, User user);
	
	public User updateUserPassword(String id, String password);

	public void deleteUser(int id) throws UserNotFoundException;
	
	public User getUserByEmail(String email) throws UserNotFoundException;
	
	public User login(String email, String password) throws UserNotFoundException;
}
