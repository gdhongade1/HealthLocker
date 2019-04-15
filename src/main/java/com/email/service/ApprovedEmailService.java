package com.email.service;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.ApprovedEmail;
import com.email.entity.Attachment;
import com.email.entity.EmailData;
import com.email.repository.ApprovedEmailRepository;
import com.email.repository.EmailDataRepository;

@Service
public class ApprovedEmailService {
	@Autowired
	ApprovedEmailRepository repo;
	
	
	public ApprovedEmail save(ApprovedEmail email){
	    return repo.save(email);
	}
	
	public List<ApprovedEmail> findByIsDeleted(){
		  return repo.findByDeleted(false);
		}
	public List<ApprovedEmail> findAll(){
		  return (List<ApprovedEmail>) repo.findAll();
		}
	public ApprovedEmail findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}

}
