package com.example.Springboot_Internship.repository;

import com.example.Springboot_Internship.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles> findByRoleName(String roleName);
}