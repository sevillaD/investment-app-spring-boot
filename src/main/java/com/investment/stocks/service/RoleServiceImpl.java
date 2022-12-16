package com.investment.stocks.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investment.stocks.model.Role;
import com.investment.stocks.model.repository.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

	@Override
	public Role addRole(Role role) {
		
		LocalDateTime createdDate = LocalDateTime.now();
		role.setCreatedDate(createdDate);
		
		return roleRepo.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		
		LocalDateTime lastUpdatedDate = LocalDateTime.now();
		role.setLastUpdatedDate(lastUpdatedDate);
		
		return roleRepo.save(role);
	}

	@Override
	public Optional<Role> getRoleById(Integer roleId) {
		return roleRepo.findById(roleId);
	}

	@Override
	public void deleteRole(Integer roleId) {
		roleRepo.deleteById(roleId);
	}

}
