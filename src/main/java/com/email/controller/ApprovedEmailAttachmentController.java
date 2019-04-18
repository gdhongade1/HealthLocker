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

import com.email.entity.ApprovedEmailAttachment;
import com.email.entity.EmailData;
import com.email.entity.EmailDataAttachment;
import com.email.service.ApprovedEmailAttachmentService;
import com.email.service.EmailDataAttachmentService;

@RestController
@RequestMapping({"/approvedEmailAttachment"})
public class ApprovedEmailAttachmentController {
	

	@Autowired
	ApprovedEmailAttachmentService service;
	
	@PostMapping
	public ResponseEntity<ApprovedEmailAttachment> create(@RequestBody ApprovedEmailAttachment email,Principal principal){
		ApprovedEmailAttachment emailatt=null;
		if(principal!=null) {
			emailatt=service.save(email);
			return new ResponseEntity<ApprovedEmailAttachment>(emailatt,HttpStatus.OK);
		}
		return new ResponseEntity<ApprovedEmailAttachment>(emailatt,HttpStatus.UNAUTHORIZED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ApprovedEmailAttachment>> findAll(Principal principal){
		List<ApprovedEmailAttachment> emailList=null;
		if(principal!=null) {
			 emailList=service.findAll();
			return new ResponseEntity<List<ApprovedEmailAttachment>>(emailList,HttpStatus.OK);
		}
		return new ResponseEntity<List<ApprovedEmailAttachment>>(emailList,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ApprovedEmailAttachment> updateById(@PathVariable Long id, @RequestBody ApprovedEmailAttachment email,Principal principal) {
		ApprovedEmailAttachment emailatt=null;
		if(principal!=null) {
			 emailatt=service.save(email);
			return new ResponseEntity<ApprovedEmailAttachment>(emailatt,HttpStatus.OK);
		}
		return new ResponseEntity<ApprovedEmailAttachment>(emailatt,HttpStatus.UNAUTHORIZED);
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
