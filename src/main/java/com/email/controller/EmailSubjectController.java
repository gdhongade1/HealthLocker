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

import com.email.entity.EmailSubject;
import com.email.entity.UserRegistration;
import com.email.service.EmailSubjectService;
import com.email.service.UserRegistrationService;

@RestController
@RequestMapping({"/emailSubject"})
public class EmailSubjectController {
	

	@Autowired
	EmailSubjectService service;
	
	@PostMapping
	public EmailSubject create(@RequestBody EmailSubject user){
	    return service.save(user);
	}
	
	@GetMapping
	public List<EmailSubject> findAll(){
	  return service.findAll();
	}
	
	@PutMapping(value="/{id}")
	public EmailSubject updateById(@PathVariable Long id, @RequestBody EmailSubject user) {
		return service.save(user);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "success..";
	}



}
