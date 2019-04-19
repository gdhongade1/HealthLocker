package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.EmailSpecification;
import com.email.entity.EmailSubject;
import com.email.repository.EmailSpecificationRepository;
import com.email.repository.EmailSubjectRepository;

@Service
public class EmailSpecificationService {
	
	@Autowired
	EmailSpecificationRepository repo;
	
	public List<EmailSpecification> saveAll(List<EmailSpecification> emailList){
	    return (List<EmailSpecification>) repo.save(emailList);
	}

}
