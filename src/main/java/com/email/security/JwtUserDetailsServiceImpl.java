package com.email.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.email.UserRepository;
import com.email.entity.UserRegistration;
import com.email.model.User;
import com.email.repository.UserRegistrationRepository;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRegistrationRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserRegistration user=userRepository.findByEmailAddressIgnoreCase(username);
		if(user==null) {
			throw new UsernameNotFoundException(String.format("NO Of Found with Username '%s'", username));
		}
		
		return JwtuserFactory.create(user);
	}
}
