package com.investment.stocks.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investment.stocks.model.Role;
import com.investment.stocks.model.User;
import com.investment.stocks.model.repository.RoleRepository;
import com.investment.stocks.model.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/**@Autowired
	private PasswordEncoder passwordEncoder;**/
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return userRepo.findById(userId);
	}
	
	@Override
	public User addUser(User newUser) throws Exception {
		
		List<User> users = userRepo.findAll();
		
		for(User user: users) {
			if(user.getEmail().equalsIgnoreCase(newUser.getEmail())) {
				throw new Exception("User already exists");
			}
		}
		
		/**user.setPassword(passwordEncoder.encode(user.getPassword()));**/
		return userRepo.save(newUser);
	}
	

	@Override
	public User updateUser(User user) {
		
		Set<Role> roles = new HashSet<>(user.getRoles());
		user.setRoles(roles);
		
		return userRepo.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public Optional<User> findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}


}
