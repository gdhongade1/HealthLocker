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
import com.email.entity.EmailData;
import com.email.model.User;
import com.email.service.EmailDataService;

@RestController
@RequestMapping({"/emailData"})
public class EmailDataController {
	
	public static final String STATUS_DECLINED="Declined";
	public static final String STATUS_NEW="New";
	
	@Autowired
	EmailDataService service;
	
	@PostMapping
	public ResponseEntity<EmailData> create(@RequestBody EmailData email,Principal principal){
		EmailData emaildata=null;
		if(principal!=null) {
			emaildata=service.save(email);
			return new ResponseEntity<EmailData>(emaildata,HttpStatus.OK);
		}
		 return new ResponseEntity<EmailData>(emaildata,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping
	public ResponseEntity<List<EmailData>> findAll(Principal principal){
		List<EmailData> emaildata=null;
		if(principal!=null) {
			emaildata=service.findAll();
			return new ResponseEntity<List<EmailData>>(emaildata,HttpStatus.OK);
		}
		 return new ResponseEntity<List<EmailData>>(emaildata,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/new")
	public ResponseEntity<List<EmailData>> findByStatus(Principal principal){
		List<EmailData> emaildata=null;
		if(principal!=null) {
			emaildata=service.findByStatus(STATUS_NEW);
			return new ResponseEntity<List<EmailData>>(emaildata,HttpStatus.OK);
		}
		 return new ResponseEntity<List<EmailData>>(emaildata,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<EmailData> updateById(@PathVariable Long id, @RequestBody EmailData email,Principal principal) {
		EmailData emaildata=null;
		if(principal!=null) {
			emaildata=service.save(email);
			return new ResponseEntity<EmailData>(emaildata,HttpStatus.OK);
		}
		 return new ResponseEntity<EmailData>(emaildata,HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable Long id,Principal principal) {
		EmailData emaildata=null;
		if(principal!=null) {
			emaildata=service.findById(id);
			emaildata.setStatus(STATUS_DECLINED);
			EmailData added =service.save(emaildata);
			if(added!=null) {
				return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
			}
		}
		 return new ResponseEntity<String>("Not deleted",HttpStatus.UNAUTHORIZED);
		
	}

}
