package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.EmailDataAttachment;
import com.email.entity.EmailSubject;
import com.email.repository.EmailDataAttachmentRepository;
import com.email.repository.EmailSubjectRepository;

@Service
public class EmailDataAttachmentService {
	@Autowired
	EmailDataAttachmentRepository repo;
	
	public EmailDataAttachment save(EmailDataAttachment user){
	    return repo.save(user);
	}
	
	public List<EmailDataAttachment> findAll(){
		  return (List<EmailDataAttachment>) repo.findAll();
		}
	public EmailDataAttachment findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}

}
