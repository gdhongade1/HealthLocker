package com.email.domain;

import java.io.Serializable;

import com.email.entity.UserRegistration;
import com.email.model.User;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4847786357753768449L;
	
	private UserRegistration user;
	private String token;
	
	public UserDTO(UserRegistration user, String token) {
		super();
		this.user = user;
		this.token = token;
	}

	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
