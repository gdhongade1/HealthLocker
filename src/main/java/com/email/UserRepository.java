package com.email;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.email.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByEmailIgnoreCase(String username);

	

}
