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

import com.email.entity.ApprovedEmail;
import com.email.entity.EmailData;
import com.email.service.ApprovedEmailService;
import com.email.service.EmailDataService;

@RestController
@RequestMapping({"/approvedEmail"})
public class ApprovedEmailController {
	
	@Autowired
	ApprovedEmailService service;
	
	
	@PostMapping
	public ApprovedEmail create(@RequestBody ApprovedEmail email){
	    return service.save(email);
	}
	
	@GetMapping
	public List<ApprovedEmail> findAll(){
	  return service.findAll();
	}
	
	@GetMapping("/approved")
	public List<ApprovedEmail> findByIsDeleted(){
	  return service.findByIsDeleted();
	}
	
	@PutMapping(value="/{id}")
	public ApprovedEmail updateById(@PathVariable Long id, @RequestBody ApprovedEmail email) {
		//email.setEmail_user_id(id);;
		return service.save(email);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable Long id) {
		ApprovedEmail apEmail= service.findById(id);
		apEmail.setDeleted(true);
		service.save(apEmail);
		return "success..";
	}

}
