package com.nickdev.springsecurityjwt.repositories;
import com.nickdev.springsecurityjwt.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);

    Users findByUserEmail(String useremail);
}
