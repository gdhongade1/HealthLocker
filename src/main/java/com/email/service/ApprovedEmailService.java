package com.email.service;

import java.security.Principal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	public List<ApprovedEmail> findByHide(){
		  return repo.findByHide(true);
		}
	
	public List<ApprovedEmail> findByStar(){
		  return repo.findByStar(true);
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

	public String hideUnhideEmail(boolean status,Long id){
		repo.hideUnhideEmail(status,id);
		return "success..";
	}
	
	public String starUnstar(boolean status,Long id){
		repo.starUnstar(status,id);
		return "success..";
	}
	
	public ApprovedEmail getOne(Long id){
			return repo.findOne(id);
	}

}
