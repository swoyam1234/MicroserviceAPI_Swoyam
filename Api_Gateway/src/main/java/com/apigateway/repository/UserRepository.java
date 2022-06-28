package com.apigateway.repository;

import org.springframework.data.repository.CrudRepository;

import com.apigateway.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUserName(String username);

}
