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

import com.investment.stocks.model.Role;
import com.investment.stocks.service.IRoleService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private IRoleService roleService;
	
	/** endpoint: localhost:8000/role/all**/
	@GetMapping("/all")
	public ResponseEntity<?> getAllRoles(){
		return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
	}
	
	/** localhost:8000/role/get-role/1 **/
	@GetMapping("/get-role/{roleId}")
	public ResponseEntity<?> getRoleById(@PathVariable Integer roleId){
		return new ResponseEntity<>(roleService.getRoleById(roleId), HttpStatus.OK);
	}
	

	@PostMapping("add-role")
	public ResponseEntity<?> addRole(@RequestBody Role role){
		return new ResponseEntity<>(roleService.addRole(role), HttpStatus.CREATED);
	}
	
	@PutMapping("/update-role")
	public ResponseEntity<?> updateRole(@RequestBody Role role){
		return new ResponseEntity<>(roleService.updateRole(role), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delete/{roleId}")
	public void deleteRole(@PathVariable Integer roleId) {
		roleService.deleteRole(roleId);
	}
	

}
