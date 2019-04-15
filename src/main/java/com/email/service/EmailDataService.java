package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.EmailData;
import com.email.repository.EmailDataRepository;

@Service
public class EmailDataService {
	@Autowired
	EmailDataRepository repo;
	
	public EmailData save(EmailData email){
	    return repo.save(email);
	}
	
	public List<EmailData> findAll(){
		  return (List<EmailData>) repo.findAll();
		}
	

	public List<EmailData> findByStatus(String status){
		  return (List<EmailData>) repo.findByStatus(status);
		}
	
	public EmailData findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}

}
