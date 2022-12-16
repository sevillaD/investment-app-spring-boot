package com.investment.stocks.service;

import java.util.List;
import java.util.Optional;

import com.investment.stocks.model.Role;

public interface IRoleService {
	
	List<Role> getAllRoles();
	
	Optional<Role> getRoleById(Integer roleId);
	
	void deleteRole(Integer roleID);
	
	Role addRole(Role role);
	
	Role updateRole(Role role);
	
}
