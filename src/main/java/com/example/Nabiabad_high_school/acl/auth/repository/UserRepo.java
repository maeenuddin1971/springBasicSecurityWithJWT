package com.example.Nabiabad_high_school.acl.auth.repository;

import com.example.Nabiabad_high_school.acl.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUserName(String username);

    User getUserByUserName(String user);
}
