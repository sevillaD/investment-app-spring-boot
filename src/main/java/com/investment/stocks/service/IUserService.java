package com.investment.stocks.service;

import java.util.List;
import java.util.Optional;

import com.investment.stocks.model.User;

public interface IUserService {
	
	
	List<User> getAllUsers();
	
	Optional<User> getUserById(Long userId);
	
	Optional<User> findUserByEmail(String email);
	
	User addUser(User user) throws Exception;
	
	User updateUser(User user);
	
	void deleteUser(Long userId);
	

}
