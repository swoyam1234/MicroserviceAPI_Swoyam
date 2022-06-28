package com.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.config.JwtUtil;
import com.apigateway.entity.JwtRequest;
import com.apigateway.entity.JwtResponse;
import com.apigateway.service.UserDetailsServiceImpl;

@RestController
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try {
			
			authenticate(jwtRequest.getUserName(), jwtRequest.getPassword());
			
		}catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("User not found");
		}
		
		
		UserDetails userDetails =this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUserName());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	
	
	private void authenticate(String userName, String password) throws Exception
	{
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
			
		}catch(DisabledException e)
		{
			throw new Exception("User Disabled" + e.getMessage());
		}catch(BadCredentialsException e)
		{
			throw new Exception("Invalid Credentials" + e.getMessage());
		}
		
	}

}
