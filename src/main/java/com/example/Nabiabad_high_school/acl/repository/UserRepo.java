package com.example.Nabiabad_high_school.acl.repository;

import com.example.Nabiabad_high_school.acl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUserName(String userName);

    User findByUserCode(String code);
}
