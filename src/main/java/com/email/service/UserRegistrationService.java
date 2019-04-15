package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.UserRegistration;
import com.email.passwordutil.PasswordUtil;
import com.email.repository.UserRegistrationRepository;
import com.email.repository.UserRegistrationRepository;

@Service
public class UserRegistrationService {
	
	@Autowired
	UserRegistrationRepository repo;
	
	public UserRegistration save(UserRegistration user){
		String password=PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
	    return repo.save(user);
	}
	
	public List<UserRegistration> findAll(){
		  return (List<UserRegistration>) repo.findAll();
		}
	public UserRegistration findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}

}
