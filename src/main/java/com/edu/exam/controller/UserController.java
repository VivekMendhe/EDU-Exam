package com.edu.exam.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.edu.exam.model.Role;
import com.edu.exam.model.User;
import com.edu.exam.model.UserRole;
import com.edu.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

//	@PostMapping
//	public User createUser(@RequestBody User user) throws Exception {
//
//		Role role = new Role(45L, "Normal");
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
//		Set<UserRole> roles = new HashSet<>();
//		roles.add(userRole);
//		return this.userService.createUser(user, roles);
//	}

//	@PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
//		Role role = new Role(45L, "Normal");
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role);
//		Set<UserRole> roles = new HashSet<>();
//		roles.add(userRole);
//        User createdUser = this.userService.createUser(user, roles);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			User createdUser = this.userService.createUserWithDefaultRole(user);
			return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@CrossOrigin("*")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		Optional<User> userOptional = userService.findById(id);
		if (userOptional.isPresent()) {
			return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
		}
	}
	
	@GetMapping("/byUsername/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
	    User user = userService.findByUsername(username);
	    if (user != null) {
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    } else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
	    } 
	}


	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) throws Exception {
		user.setUid(id); // ensure we're updating the correct user
		User updatedUser = userService.updateUser(user);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
		userService.deleteById(id);
		System.out.println("User not found");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
