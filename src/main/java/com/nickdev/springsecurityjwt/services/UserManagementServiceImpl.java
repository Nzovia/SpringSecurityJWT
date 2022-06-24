package com.nickdev.springsecurityjwt.services;

import com.nickdev.springsecurityjwt.models.Roles;
import com.nickdev.springsecurityjwt.models.Users;
import com.nickdev.springsecurityjwt.repositories.RolesRepository;
import com.nickdev.springsecurityjwt.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserManagementServiceImpl implements UserManagentService {
    private final UserRepository userRepo;
    private final RolesRepository rolesRepo;


    @Override
    public Users createUser(Users appUser) {
        log.info("adding user to the Db");
        return userRepo.save(appUser);
    }

    @Override
    public Roles saveRole(Roles roles) {
        log.info("adding roles to the Db");
        return rolesRepo.save(roles);
    }

    @Override
    public void addRolesToUsers(String useremail, String roleName) {
        Users user = userRepo.findByUserEmail(useremail);
        Roles role = rolesRepo.findByRoleName(roleName);
        log.info("adding roles to the appUser");

        user.getRoles().add(role);

    }

    @Override
    public Users getUsersbyUserName(String username) {
        log.info("finding user by their userNames");
        return userRepo.findByUsername(username);
    }

    @Override
    public List<Users> getAllAppUsers() {
        log.info("list all users in the app");
        return userRepo.findAll();
    }
}