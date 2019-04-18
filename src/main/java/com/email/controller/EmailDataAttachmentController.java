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
import com.email.entity.EmailDataAttachment;
import com.email.service.EmailDataAttachmentService;

@RestController
@RequestMapping({"/emailDataAttachment"})
public class EmailDataAttachmentController {
	@Autowired
	EmailDataAttachmentService service;
	
	@PostMapping
	public ResponseEntity<EmailDataAttachment> create(@RequestBody EmailDataAttachment user,Principal principal){
		EmailDataAttachment appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<EmailDataAttachment>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<EmailDataAttachment>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmailDataAttachment>> findAll(Principal principal){
		
		List<EmailDataAttachment> appEmail=null;
		if(principal!=null) {
			appEmail= service.findAll();
			return new ResponseEntity<List<EmailDataAttachment>>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<List<EmailDataAttachment>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<EmailDataAttachment> updateById(@PathVariable Long id, @RequestBody EmailDataAttachment user,Principal principal) {
		EmailDataAttachment appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<EmailDataAttachment>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<EmailDataAttachment>(appEmail,HttpStatus.UNAUTHORIZED);
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
