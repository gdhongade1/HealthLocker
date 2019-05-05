package com.email.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.entity.Subject;
import com.email.entity.UserAddress;
import com.email.repository.SubjectRepository;
import com.email.repository.UserAddressRepository;

@Service
public class UserAddressService {

	
	@Autowired
	UserAddressRepository repo;
	
	public UserAddress save(UserAddress email){
	    return repo.save(email);
	}
	
	public List<UserAddress> findAll(){
		  return (List<UserAddress>) repo.findAll();
		}
	public UserAddress findById(Long id){
		  return  repo.findOne(id);
		}
	
	public String deleteById( Long id) {
		repo.delete(id);
		return "success..";
	}
	
	public List<UserAddress> findByUserId(Long id){
		
		  return (List<UserAddress>) repo.findByUserId(id);
	}

}
