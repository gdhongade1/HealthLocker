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
	public Attachment create(@RequestBody Attachment user){
	    return service.save(user);
	}
	
	@PostMapping(value="/add")
	public Attachment add(){
		Attachment a = new Attachment();
		a.setEmail_Id(1);
		a.setFileId(1);
		a.setFilePath("FIlepAth");
		a.setFileSize(55);
		a.setFileType("Text");
		a.setUser_id(1);
	    return service.save(a);
	}
	
	
	@GetMapping
	public List<Attachment> findAll(){
	  return service.findAll();
	}
	
	@PutMapping(value="/{id}")
	public Attachment updateById(@PathVariable Long id, @RequestBody Attachment user) {
		return service.save(user);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "success..";
	}


}
