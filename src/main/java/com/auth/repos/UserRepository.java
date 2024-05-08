package com.auth.repos;

import com.auth.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}
