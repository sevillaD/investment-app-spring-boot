package com.investment.stocks.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.investment.stocks.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Role findByName(String name);
	
}
