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

import com.email.entity.Remark;
import com.email.entity.Specification;
import com.email.service.RemarkService;
import com.email.service.SpecificationService;

@RestController
@RequestMapping({"/remark"})
public class RemarkController {
	@Autowired
	RemarkService service;
	
	@PostMapping
	public Remark create(@RequestBody Remark user){
	    return service.save(user);
	}
	
	@GetMapping
	public List<Remark> findAll(){
	  return service.findAll();
	}
	
	@PutMapping(value="/{id}")
	public Remark updateById(@PathVariable Long id, @RequestBody Remark user) {
		return service.save(user);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "success..";
	}

}
