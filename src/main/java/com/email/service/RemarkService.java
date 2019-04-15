package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.Remark;
import com.email.entity.Specification;
import com.email.repository.RemarkRepository;
import com.email.repository.SpecificationRepository;

@Service
public class RemarkService {
	@Autowired
	RemarkRepository repo;
	
	public Remark save(Remark email){
	    return repo.save(email);
	}
	
	public List<Remark> findAll(){
		  return (List<Remark>) repo.findAll();
		}
	public Remark findById(int id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( int id) {
		repo.delete(id);
		return "success..";
	}

}
