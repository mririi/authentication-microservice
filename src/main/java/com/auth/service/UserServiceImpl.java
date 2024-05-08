package com.auth.service;

import com.auth.entities.Role;
import com.auth.entities.Users;
import com.auth.repos.RoleRepository;
import com.auth.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRep;
	@Autowired
	RoleRepository roleRep;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Users saveUser(Users user) {
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	return userRep.save(user);
	}
	@Override
	public Users addRoleToUser(String username, String rolename) {
	Users usr = userRep.findByUsername(username);
	Role r = roleRep.findByRole(rolename);
	usr.getRoles().add(r);
	return usr;
	}
	@Override
	public Role addRole(Role role) {
	return roleRep.save(role);
	}
	@Override
	public Users findByUsername(String username) {
	return userRep.findByUsername(username);
	}

}
