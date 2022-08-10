package com.nickdev.springsecurityjwt;

import com.nickdev.springsecurityjwt.models.Roles;
import com.nickdev.springsecurityjwt.models.Users;
import com.nickdev.springsecurityjwt.services.UserManagementService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean CommandLineRunner runner(
            UserManagementService userManagementService
    ){
        return args -> {
            userManagementService.createUser(new Users(null, "Nicholas", "nichonzovia@gmail.com", "123$Nick", new ArrayList<>()));
            userManagementService.createUser(new Users(null, "Maundu", "maundu@gmail.com", "123$Man", new ArrayList<>()));
            userManagementService.createUser(new Users(null, "Fidelis", "fidelis@gmail.com", "123$Nick", new ArrayList<>()));
            userManagementService.createUser(new Users(null, "Mueni", "mueni@gmail.com", "123$Nick", new ArrayList<>()));

            userManagementService.saveRole(new Roles(null, "USER"));
            userManagementService.saveRole(new Roles(null, "ADMIN"));
            userManagementService.saveRole(new Roles(null, "OFFICER"));
            userManagementService.saveRole(new Roles(null, "SUPER_ADMIN"));


            //Adding roles to users
            userManagementService.addRolesToUsers("nichonzovia@gmail.com", "ADMIN");
            userManagementService.addRolesToUsers("maundu@gmail.com", "USER");
            userManagementService.addRolesToUsers("fidelis@gmail.com", "OFFICER");
            userManagementService.addRolesToUsers("mueni@gmail.com", "SUPER_ADMIN");
            userManagementService.addRolesToUsers("mueni@gmail.com", "USER");





        };
    }

}
