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

import com.email.entity.EmailDataAttachment;
import com.email.service.EmailDataAttachmentService;

@RestController
@RequestMapping({"/emailDataAttachment"})
public class EmailDataAttachmentController {
	@Autowired
	EmailDataAttachmentService service;
	
	@PostMapping
	public EmailDataAttachment create(@RequestBody EmailDataAttachment user){
	    return service.save(user);
	}
	
	@GetMapping
	public List<EmailDataAttachment> findAll(){
	  return service.findAll();
	}
	
	@PutMapping(value="/{id}")
	public EmailDataAttachment updateById(@PathVariable Long id, @RequestBody EmailDataAttachment user) {
		return service.save(user);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "success..";
	}


}
