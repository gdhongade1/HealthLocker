package com.email.prelogin.service;

import java.util.List;

import com.email.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
