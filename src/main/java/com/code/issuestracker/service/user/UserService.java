package com.code.issuestracker.service.user;

import com.code.issuestracker.entity.Role;
import com.code.issuestracker.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
