package com.code.helpdesk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.code.helpdesk.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	User findByEmail(String email);

}