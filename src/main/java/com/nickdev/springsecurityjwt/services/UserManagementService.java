package com.nickdev.springsecurityjwt.services;

import com.nickdev.springsecurityjwt.models.Roles;
import com.nickdev.springsecurityjwt.models.Users;

import java.util.List;

public interface UserManagementService {
    Users createUser(Users appUser);
    Roles saveRole(Roles roles);
    void addRolesToUsers(String userEmail, String roleName);
    Users getUsersbyUserName(String userName);
    List <Users> getAllAppUsers();
}
