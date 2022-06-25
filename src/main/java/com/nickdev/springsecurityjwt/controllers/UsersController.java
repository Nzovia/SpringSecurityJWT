package com.nickdev.springsecurityjwt.controllers;

import com.nickdev.springsecurityjwt.models.Roles;
import com.nickdev.springsecurityjwt.models.Users;
import com.nickdev.springsecurityjwt.payload.UserRole;
import com.nickdev.springsecurityjwt.services.UserManagementServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserManagementServiceImpl userService;

    @GetMapping("/listUsers")
    public ResponseEntity<List<Users>> listUsers(){
        return ResponseEntity.ok(userService.getAllAppUsers());
    }

    @PostMapping("/createUser")
    public ResponseEntity<Users> creatUser(@RequestBody Users users){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users/createUser").toUriString());
        return ResponseEntity.created(uri).body(userService.createUser(users));
    }

    @PostMapping("/addRole")
    public ResponseEntity<Roles> creatUser(@RequestBody Roles roles){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users/addRole").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(roles));
    }

    @PostMapping("/addNewUserRole")
    public ResponseEntity<?> addRoleToUser(@RequestBody UserRole userRole){
        userService.addRolesToUsers(userRole.getUserEmail(), userRole.getRoleName());
        return ResponseEntity.ok().build(); //we just need to build the response since there is nothing we are returning
    }

}
