package com.example.Nabiabad_high_school.repository.system;

import com.example.Nabiabad_high_school.entity.system.SystemMenu;
import com.example.Nabiabad_high_school.repository.generic.GenericRepository;

import java.util.Optional;

public interface SystemMenuRepository extends GenericRepository<SystemMenu> {

    boolean existsByCode(String system);

    SystemMenu getByCode(String system);

    SystemMenu findByCode(String auth_user);


    SystemMenu findSystemMenuByRequestUrl(String url);

    SystemMenu findSystemMenuByUrl(String url);

    Optional<SystemMenu> findByUrl(String reqUrl);

}
