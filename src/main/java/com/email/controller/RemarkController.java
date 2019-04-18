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
	public ResponseEntity<Remark> create(@RequestBody Remark user,Principal principal){
		Remark appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<Remark>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<Remark>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping
	public ResponseEntity<List<Remark>> findAll(Principal principal){
		List<Remark> appEmail=null;
		if(principal!=null) {
			appEmail= service.findAll();
			return new ResponseEntity<List<Remark>>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<List<Remark>>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Remark> updateById(@PathVariable Long id, @RequestBody Remark user,Principal principal) {
		Remark appEmail=null;
		if(principal!=null) {
			appEmail=service.save(user);
			return new ResponseEntity<Remark>(appEmail,HttpStatus.OK);
		}
		return new ResponseEntity<Remark>(appEmail,HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity<String> deleteById(@PathVariable int id,Principal principal) {
		if(principal!=null) {
			service.deleteById(id);
			return new ResponseEntity<String>("success..",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed..",HttpStatus.UNAUTHORIZED);
	}

}
