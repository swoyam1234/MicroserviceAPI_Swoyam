package com.apigateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.apigateway.entity.Role;
import com.apigateway.entity.User;
import com.apigateway.repository.RoleRepository;
import com.apigateway.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting code");
		
		Role role1 = new Role(1, "ROLE_ADMIN");
		Role role2 = new Role(2, "ROLE_USER");
		
		Role r1=roleRepository.save(role1);
		Role r2=roleRepository.save(role2);
		
		List<Role> list = new ArrayList<>();
		
		list.add(role1);
		list.add(role2);
		User user = new User();
		user.setUserName("SwoyamSekharSahoo");
		String password = "Swoyam1234";
		user.setPassword(passwordEncoder.encode(password));
		user.setRoles(list);
		
		userRepository.save(user);
		
		
		
	}

}
