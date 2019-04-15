package com.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UserRegistration create(@RequestBody UserRegistration user){
	    return service.save(user);
	}
	
	@GetMapping
	public List<UserRegistration> findAll(){
	  return service.findAll();
	}
	
	@PutMapping(value="/{id}")
	public UserRegistration updateById(@PathVariable Long id, @RequestBody UserRegistration user) {
		return service.save(user);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "success..";
	}

}
