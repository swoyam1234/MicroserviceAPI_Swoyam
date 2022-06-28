package com.apigateway.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.entity.Role;
import com.apigateway.entity.User;
import com.apigateway.repository.RoleRepository;
import com.apigateway.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("/resister")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		List<Role> roles= new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		User u = userRepository.save(user);
		
		return ResponseEntity.ok(u);
		
	}

}
