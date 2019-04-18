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
import com.email.entity.Attachment;
import com.email.entity.UserRegistration;
import com.email.service.AttachmentService;
import com.email.service.UserRegistrationService;

@RestController
@RequestMapping({"/attachment"})
public class AttachmentController {
	@Autowired
	AttachmentService service;
	
	@PostMapping
	public ResponseEntity<Attachment> create(@RequestBody Attachment attachment,Principal principal){
		Attachment attachment1=null;
		if(principal!=null) {
			attachment1=service.save(attachment);
			return new ResponseEntity<Attachment>(attachment1,HttpStatus.OK);
		}
		return new ResponseEntity<Attachment>(attachment1,HttpStatus.UNAUTHORIZED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Attachment>> findAll(Principal principal){
		
		List<Attachment> appEmail=null;
		if(principal!=null) {
			appEmail= service.findAll();
			return new ResponseEntity<List<Attachment>>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<List<Attachment>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Attachment> updateById(@PathVariable Long id, @RequestBody Attachment user,Principal principal) {
		Attachment appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<Attachment>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<Attachment>(appEmail,HttpStatus.UNAUTHORIZED);
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
