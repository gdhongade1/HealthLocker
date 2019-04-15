package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.EmailSubject;
import com.email.entity.UserRegistration;
import com.email.repository.EmailSubjectRepository;
import com.email.repository.UserRegistrationRepository;

@Service
public class EmailSubjectService {
	
	
	@Autowired
	EmailSubjectRepository repo;
	
	public EmailSubject save(EmailSubject user){
	    return repo.save(user);
	}
	
	public List<EmailSubject> findAll(){
		  return (List<EmailSubject>) repo.findAll();
		}
	public EmailSubject findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}



}
