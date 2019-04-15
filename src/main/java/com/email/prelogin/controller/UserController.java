package com.email.prelogin.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.User;
import com.email.prelogin.service.UserService;

@RestController
public class UserController {
	
	private static final Logger logger=LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	//@PreAuthorize("hasRole('ADMIN')")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<User>> getAllUser(){
		logger.info("getAllUser Details...");
		List<User> users=userService.findAll();
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	
	@GetMapping("/getuser")
	//@PreAuthorize("hasRole('USER')")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<User> getUser(Principal principal){
		logger.info("get User Details...");
		User user=userService.getUserByEmail(principal.getName());
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}
