package com.code.issuestracker;

import com.code.issuestracker.entity.Role;
import com.code.issuestracker.entity.User;
import com.code.issuestracker.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class IssuesTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssuesTrackerApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

/*	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			userService.saveRole(new Role(null, "Role_USER"));
			userService.saveRole(new Role(null, "Role_MANAGER"));
			userService.saveRole(new Role(null, "Role_ADMIN"));
			userService.saveRole(new Role(null, "Role_SUPER_ADMIN"));


			userService.saveUser(new User(null, "aimad","aimad", "aimad", "aimad@test.com", "aimadaimad", new ArrayList<>()));
			userService.saveUser(new User(null, "yassin EL","yassin", "yassin", "yassin@test.com", "aimadaimad", new ArrayList<>()));
			userService.saveUser(new User(null, "hajar EL", "hajar", "hajar","hajar@test.com", "aimadaimad", new ArrayList<>()));
			userService.saveUser(new User(null, "ziad EL", "ziad","ziad", "ziad@test.com", "aimadaimad", new ArrayList<>()));


			userService.addRoleToUser("aimad", "Role_SUPER_ADMIN");
			userService.addRoleToUser("ziad", "Role_ADMIN");
			userService.addRoleToUser("hajar", "Role_USER");
			userService.addRoleToUser("yassin", "Role_ADMIN");
		};
	}*/
}
