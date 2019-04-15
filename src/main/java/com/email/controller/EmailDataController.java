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

import com.email.entity.EmailData;
import com.email.service.EmailDataService;

@RestController
@RequestMapping({"/emailData"})
public class EmailDataController {
	
	@Autowired
	EmailDataService service;
	
	@PostMapping
	public EmailData create(@RequestBody EmailData email){
	    return service.save(email);
	}
	
	@GetMapping
	public List<EmailData> findAll(){
	  return service.findAll();
	}
	
	@PutMapping(value="/{id}")
	public EmailData updateById(@PathVariable Long id, @RequestBody EmailData email) {
		//email.setEmail_user_id(id);;
		return service.save(email);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "success..";
	}

}
