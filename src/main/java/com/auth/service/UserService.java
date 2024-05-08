package com.auth.service;

import com.auth.entities.Role;
import com.auth.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
	Users saveUser(Users user);
	Users findByUsername (String username);
	@Autowired
	Role addRole(Role role);
	Users addRoleToUser(String username, String rolename);
}
