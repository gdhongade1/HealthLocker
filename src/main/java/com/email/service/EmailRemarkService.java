package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.EmailRemark;
import com.email.entity.EmailSpecification;
import com.email.repository.EmailRemarkRepository;
import com.email.repository.EmailSpecificationRepository;

@Service
public class EmailRemarkService {
	
	@Autowired
	EmailRemarkRepository repo;
	
	public List<EmailRemark> saveAll(List<EmailRemark> emailList){
	    return (List<EmailRemark>) repo.save(emailList);
	}


}
