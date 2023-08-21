package com.edu.exam.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.exam.model.Role;
import com.edu.exam.model.User;
import com.edu.exam.model.UserRole;
import com.edu.exam.repository.RoleRepository;
import com.edu.exam.repository.UserRepository;
import com.edu.exam.services.UserService;

@Service 
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository urepo;

	@Autowired
	private RoleRepository rrepo;

	/**
	 * This method will responsible for creating user.
	 */
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		User local = this.urepo.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("User is already existed");
			throw new Exception("User is already existed");
		} else {
			for (UserRole ur : userRoles) {
				rrepo.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.urepo.save(user);
		}
		return local;
	}
	
	@Override
	public User createUserWithDefaultRole(User user) throws Exception {
	    Role defaultRole = new Role(45L, "Normal");
	    UserRole userRole = new UserRole();
	    userRole.setUser(user);
	    userRole.setRole(defaultRole);

	    Set<UserRole> roles = new HashSet<>();
	    roles.add(userRole);

	    return createUser(user, roles);
	}

	
	// Chat GPT Generated
	
	@Override
    public List<User> findAll() {
        return urepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return urepo.findById(id);
    }

    @Override
    public User updateUser(User user) throws Exception {
        if(urepo.existsById(user.getUid())) {
            return urepo.save(user);
        } else {
            throw new Exception("User not found");
        }
    }

    @Override
    public void deleteById(Long id) {
        urepo.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return urepo.findByUsername(username);
    }

}
