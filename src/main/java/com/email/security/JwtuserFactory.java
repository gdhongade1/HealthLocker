package com.email.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.email.entity.UserRegistration;
import com.email.model.User;

public class JwtuserFactory {

	public static JwtUser create(UserRegistration user) {
		// TODO Auto-generated method stub
		return new JwtUser(user.getUser_reg_id(), user.getEmailAddress(), user.getPassword(),user, maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE"+user.getRole()))), user.isEnabled());
	}

	private static List<GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
		// TODO Auto-generated method stub
		return authorities.stream().map(Authority->new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}

}
