package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.ApprovedEmailAttachment;
import com.email.entity.EmailDataAttachment;
import com.email.entity.EmailRemark;
import com.email.repository.ApprovedEmailAttachmentRepository;
import com.email.repository.EmailDataAttachmentRepository;
import com.email.repository.EmailRemarkRepository;

@Service
public class ApprovedEmailAttachmentService {
	
	@Autowired
	ApprovedEmailAttachmentRepository repo;
	
	public ApprovedEmailAttachment save(ApprovedEmailAttachment user){
	    return repo.save(user);
	}
	
	public List<ApprovedEmailAttachment> findAll(){
		  return (List<ApprovedEmailAttachment>) repo.findAll();
		}
	public ApprovedEmailAttachment findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}

	
	public List<ApprovedEmailAttachment> saveAll(List<ApprovedEmailAttachment> emailList){
	    return (List<ApprovedEmailAttachment>) repo.save(emailList);
	}

}
