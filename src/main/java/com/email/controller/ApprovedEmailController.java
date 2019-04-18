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

import com.email.entity.ApprovedEmail;
import com.email.entity.ApprovedEmailAttachment;
import com.email.entity.EmailData;
import com.email.service.ApprovedEmailService;
import com.email.service.EmailDataService;

@RestController
@RequestMapping({"/approvedEmail"})
public class ApprovedEmailController {
	
	@Autowired
	ApprovedEmailService service;
	
	
	@PostMapping
	public ResponseEntity<ApprovedEmail> create(@RequestBody ApprovedEmail email,Principal principal){
		ApprovedEmail appEmail=null;
		if(principal!=null) {
			appEmail=service.save(email);
			return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping
	public ResponseEntity<List<ApprovedEmail>> findAll(Principal principal){
		List<ApprovedEmail> appEmail=null;
		if(principal!=null) {
			appEmail= service.findAll();
			return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/approved")
	public ResponseEntity<List<ApprovedEmail>> findByIsDeleted(Principal principal){
		List<ApprovedEmail> appEmail=null;
		if(principal!=null) {
			appEmail= service.findByIsDeleted();
			return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<List<ApprovedEmail>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ApprovedEmail> updateById(@PathVariable Long id, @RequestBody ApprovedEmail email,Principal principal) {
		ApprovedEmail appEmail=null;
		if(principal!=null) {
			appEmail=service.save(email);
			return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<ApprovedEmail>(appEmail,HttpStatus.UNAUTHORIZED);
		//email.setEmail_user_id(id);;
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable Long id,Principal principal) {
		if(principal!=null) {
			ApprovedEmail apEmail= service.findById(id);
			apEmail.setDeleted(true);
			service.save(apEmail);
			return new ResponseEntity<String>("success..",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..",HttpStatus.UNAUTHORIZED);
	}

}
