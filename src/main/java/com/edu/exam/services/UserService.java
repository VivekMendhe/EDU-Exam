package com.edu.exam.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.edu.exam.model.User;
import com.edu.exam.model.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRoles) throws Exception;

	// Chat GPT Generated

	List<User> findAll();

	Optional<User> findById(Long id);

	User updateUser(User user) throws Exception;

	void deleteById(Long id);

	User createUserWithDefaultRole(User user) throws Exception;
	
	User findByUsername(String username);
}
