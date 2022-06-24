package com.nickdev.springsecurityjwt.services;

import com.nickdev.springsecurityjwt.models.Roles;
import com.nickdev.springsecurityjwt.models.Users;

import java.util.List;

public interface UserManagentService {
    Users createUser(Users appUser);
    Roles saveRole(Roles roles);
    void addRolesToUsers(String useremail, String roleName);
    Users getUsersbyUserName(String username);
    List <Users> getAllAppUsers();
}
