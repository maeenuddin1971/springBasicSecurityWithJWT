package com.example.Nabiabad_high_school.acl.auth.entity.repository;

import com.example.Nabiabad_high_school.acl.auth.entity.settings.AuthType;
import com.example.Nabiabad_high_school.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthTypeRepository extends GenericRepository<AuthType> {
    AuthType findByAuthType(String url_based);
}

