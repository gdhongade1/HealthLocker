package com.email.prelogin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.domain.Response;
import com.email.model.User;
import com.email.prelogin.service.UserService;

@RestController
public class PreLoginController {
	
	private static final Logger logger=LoggerFactory.getLogger(PreLoginController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		User dbUser=userService.save(user);
		if(dbUser!=null) {
			return new ResponseEntity<>(new Response("User Is Save Successfully"),HttpStatus.OK);
		}
		
		return null;
	}

}
