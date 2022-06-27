package com.code.issuestracker.controller;

import com.code.issuestracker.entity.Role;
import com.code.issuestracker.entity.User;
import com.code.issuestracker.service.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("get useers");
        System.out.println("test get users");
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(RoleToUserForm form){
        userService.addRoleToUser(form.getUsername(), form.roleName);
        return ResponseEntity.ok().build();
    }
	/*
	@GetMapping("/role/addtouser")
	public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response){
		userService.addRoleToUser(form.getUsername(), form.roleName);
		return ResponseEntity.ok().build();
	}
	*/

    @Data
    class RoleToUserForm{
        private String username;
        private String roleName;
    }





}
