package com.auth.repos;

import com.auth.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Autowired
	Role findByRole(String role);
}
