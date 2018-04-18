package com.code.helpdesk.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.code.helpdesk.domain.User;

@Component
public interface UserService {
	User findByEmail(String email);

	User createOrUpdate(User user);

	Optional<User> findById(String id);

	void delete(String id);

	Page<User> findAll(int page, int count);

}
