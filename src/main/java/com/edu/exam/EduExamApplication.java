package com.edu.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.exam.model.Role;
import com.edu.exam.model.User;
import com.edu.exam.model.UserRole;
import com.edu.exam.services.UserService;

@SpringBootApplication
public class EduExamApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EduExamApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		System.out.println("starting code");

		User user = new User("vivek001", "Vivek", "Mendhe", "vivek@gmail.com", "9856235689", "12345678", false,
				"profile.png");

		Role r = new Role();
		r.setRoleId(44L);
		r.setRoleName("Admin");
		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(r);
		userRole.setUser(user);
		userRoleSet.add(userRole);
		User createUser = this.userService.createUser(user, userRoleSet);
		System.out.println(createUser.getUsername());
		*/
	}

}
