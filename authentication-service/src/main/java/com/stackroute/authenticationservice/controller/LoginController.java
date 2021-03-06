package com.stackroute.authenticationservice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.authenticationservice.exception.UserNotFoundException;
import com.stackroute.authenticationservice.model.User;
import com.stackroute.authenticationservice.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

class LogUser {
	public String email;
	public String password;
}

@CrossOrigin("*")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping("/users")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService ls;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<Map<String, String>> logIn(@RequestBody LogUser logUser) throws UserNotFoundException {
		logger.info("Inside the logIn user block");
		User matchedUser = ls.login(logUser.email, logUser.password);
		if (matchedUser == null) {
			logger.error("The login credentials are wrong. User not logged in.");
			throw new UserNotFoundException();
		}
		else {
			logger.info("The user has been logged in");
			String token = Jwts.builder().setId(matchedUser.getEmail()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "usersecretkey").compact();
			Map<String, String> map1 = new HashMap<>();
			map1.put("token", token);
			return new ResponseEntity<>(map1, HttpStatus.OK);
		}
	}
}