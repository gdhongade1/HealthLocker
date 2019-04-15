package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.Attachment;
import com.email.entity.Subject;
import com.email.repository.AttachmentRepository;
import com.email.repository.SubjectRepository;

@Service
public class SubjectService {
	
	@Autowired
	SubjectRepository repo;
	
	public Subject save(Subject email){
	    return repo.save(email);
	}
	
	public List<Subject> findAll(){
		  return (List<Subject>) repo.findAll();
		}
	public Subject findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}



}
