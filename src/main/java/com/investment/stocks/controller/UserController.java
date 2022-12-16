package com.investment.stocks.controller;

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

import com.investment.stocks.model.User;
import com.investment.stocks.model.repository.UserRepository;
import com.investment.stocks.service.IUserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	/** Create a register service **/
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers(){
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/get-user/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId){
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody User user) throws Exception{
		System.out.println("User object: " + user);
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delete/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
	

}
