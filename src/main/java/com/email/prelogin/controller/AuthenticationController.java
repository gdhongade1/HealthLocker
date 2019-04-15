package com.email.prelogin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.domain.UserDTO;
import com.email.exception.UnauthorizedException;
import com.email.entity.UserRegistration;
import com.email.security.JwtTokenUtil;
import com.email.security.JwtUser;

@RestController
public class AuthenticationController {
	
	private static final Logger logger=LoggerFactory.getLogger(AuthenticationController.class);

	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserRegistration user,HttpServletRequest request,HttpServletResponse response){
		
		try {
			Authentication  authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword()));
			final JwtUser userDetails=(JwtUser)authentication.getPrincipal();
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token=jwtTokenUtil.generateToken(userDetails);
			response.setHeader("Token", token);
			
			return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token),HttpStatus.OK);
		}catch(Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}
	
	
}
