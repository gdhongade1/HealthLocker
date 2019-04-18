package com.email.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.entity.UserRegistration;
import com.email.service.UserRegistrationService;

@RestController
@RequestMapping({"/userRegistration"})
public class UserRegistrationController {
	@Autowired
	UserRegistrationService service;
	
	@PostMapping
	public ResponseEntity<UserRegistration> create(@RequestBody UserRegistration user,Principal principal){
		UserRegistration appEmail=null;
			appEmail=service.save(user);
			return new ResponseEntity<UserRegistration>(appEmail,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserRegistration>> findAll(Principal principal){
		List<UserRegistration> appEmail=null;
			appEmail= service.findAll();
			return new ResponseEntity<List<UserRegistration>>(appEmail,HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<UserRegistration> updateById(@PathVariable Long id, @RequestBody UserRegistration user,Principal principal) {
		UserRegistration appEmail=null;
			appEmail=service.save(user);
			return new ResponseEntity<UserRegistration>(appEmail,HttpStatus.OK);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable Long id,Principal principal) {
			service.deleteById(id);
			return new ResponseEntity<String>("success..",HttpStatus.OK);
	}

}
