package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.ApprovedEmail;
import com.email.entity.Attachment;
import com.email.repository.ApprovedEmailRepository;
import com.email.repository.AttachmentRepository;

@Service
public class AttachmentService {
	@Autowired
	AttachmentRepository repo;
	
	public Attachment save(Attachment email){
	    return repo.save(email);
	}
	
	public List<Attachment> findAll(){
		  return (List<Attachment>) repo.findAll();
		}
	public Attachment findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}


}
