package com.auth;

import com.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthMicroserviceApplication {
       @Autowired
	   UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(AuthMicroserviceApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
	}

}
