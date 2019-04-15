package com.email.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.email.entity.UserRegistration;
import com.email.model.User;

@Repository
public interface UserRegistrationRepository extends CrudRepository<UserRegistration,Long>{
	UserRegistration findByEmailAddressIgnoreCase(String username);
}
