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

import com.email.entity.UserAddress;
import com.email.entity.UserRegistration;
import com.email.service.UserAddressService;
import com.email.service.UserRegistrationService;
@RestController
@RequestMapping({"/address"})
public class UserAddressController {
	@Autowired
	UserAddressService service;
	
	@PostMapping
	public ResponseEntity<UserAddress> create(@RequestBody UserAddress user,Principal principal){
		UserAddress appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<UserAddress>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<UserAddress>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserAddress>> findAll(Principal principal){
		List<UserAddress> appEmail=null;
		if(principal!=null) {
			appEmail= service.findAll();
			return new ResponseEntity<List<UserAddress>>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<List<UserAddress>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<UserAddress> updateById(@PathVariable Long id, @RequestBody UserAddress user,Principal principal) {
		UserAddress appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<UserAddress>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<UserAddress>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable Long id,Principal principal) {
		if(principal!=null) {
			service.deleteById(id);
			return new ResponseEntity<String>("success..",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..",HttpStatus.UNAUTHORIZED);
	}

}
