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

import com.email.entity.Attachment;
import com.email.entity.Subject;
import com.email.service.AttachmentService;
import com.email.service.SubjectService;

@RestController
@RequestMapping({"/subject"})
public class SubjectController {
	@Autowired
	SubjectService service;
	
	@PostMapping
	public ResponseEntity<Subject> create(@RequestBody Subject user,Principal principal){
		Subject appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<Subject>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<Subject>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping
	public ResponseEntity<List<Subject>> findAll(Principal principal){
		List<Subject> appEmail=null;
		if(principal!=null) {
			appEmail= service.findAll();
			return new ResponseEntity<List<Subject>>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<List<Subject>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Subject> updateById(@PathVariable Long id, @RequestBody Subject user,Principal principal) {
		Subject appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<Subject>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<Subject>(appEmail,HttpStatus.UNAUTHORIZED);
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
