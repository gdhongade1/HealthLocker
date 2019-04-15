package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.Specification;
import com.email.entity.Subject;
import com.email.repository.SpecificationRepository;
import com.email.repository.SubjectRepository;

@Service
public class SpecificationService {
	@Autowired
	SpecificationRepository repo;
	
	public Specification save(Specification email){
	    return repo.save(email);
	}
	
	public List<Specification> findAll(){
		  return (List<Specification>) repo.findAll();
		}
	public Specification findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}


}
