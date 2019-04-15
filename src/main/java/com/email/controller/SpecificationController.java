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

import com.email.entity.Specification;
import com.email.entity.Subject;
import com.email.service.SpecificationService;
import com.email.service.SubjectService;

@RestController
@RequestMapping({"/specification"})
public class SpecificationController {
	
	@Autowired
	SpecificationService service;
	
	@PostMapping
	public Specification create(@RequestBody Specification user){
	    return service.save(user);
	}
	
	@GetMapping
	public List<Specification> findAll(){
	  return service.findAll();
	}
	
	@PutMapping(value="/{id}")
	public Specification updateById(@PathVariable Long id, @RequestBody Specification user) {
		return service.save(user);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return "success..";
	}


}
