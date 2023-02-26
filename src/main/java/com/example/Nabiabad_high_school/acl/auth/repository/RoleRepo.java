package com.example.Nabiabad_high_school.acl.auth.repository;

import com.example.Nabiabad_high_school.acl.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role getRoleByRoleName(String role_user);
}
