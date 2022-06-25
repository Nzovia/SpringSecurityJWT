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
@Transactional  //makes sure that everything is saved to the DB without calling the repositories
@Slf4j
public class UserManagementServiceImpl implements UserManagementService {
    private final UserRepository userRepo;
    private final RolesRepository rolesRepo;


    @Override
    public Users createUser(Users appUser) {  //Note appUser- is DAO we are trying to save
        log.info("adding user {}to the Db", appUser.getUserName());
        return userRepo.save(appUser);
    }

    @Override
    public Roles saveRole(Roles roles) {
        log.info("adding roles {} to the Db", roles.getRoleName());
        return rolesRepo.save(roles);
    }

    @Override
    public void addRolesToUsers(String userEmail, String roleName) {
        Users user = userRepo.findByUserEmail(userEmail);
        Roles role = rolesRepo.findByRoleName(roleName);
        log.info("adding new roles {} to the appUser {}", roleName, userEmail);

        user.getRoles().add(role);

    }

    @Override
    public Users getUsersbyUserName(String userName) {
        log.info("finding user by their userNames");
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<Users> getAllAppUsers() {
        log.info("list all users in the app");
        return userRepo.findAll();

        //In situations where data is alot you fetch a whole list therefore need for Pagination
    }
}