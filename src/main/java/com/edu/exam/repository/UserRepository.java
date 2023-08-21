package com.edu.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.exam.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);

}
