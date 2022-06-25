package com.nickdev.springsecurityjwt.repositories;
import com.nickdev.springsecurityjwt.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String userName);

    Users findByUserEmail(String userEmail);
}
