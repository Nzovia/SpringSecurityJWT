package com.nickdev.springsecurityjwt.repositories;
import com.nickdev.springsecurityjwt.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Long> {
    Roles findByRoleName(String roleName);
}
