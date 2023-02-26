package com.example.Nabiabad_high_school.repository.system;

import com.example.Nabiabad_high_school.entity.system.SystemMenu;
import com.example.Nabiabad_high_school.entity.system.SystemMenuAuthorization;
import com.example.Nabiabad_high_school.repository.generic.GenericRepository;

public interface SystemMenuAuthorizationRepository extends GenericRepository<SystemMenuAuthorization> {
    SystemMenuAuthorization findBySystemMenu(SystemMenu menuInst_system);

    SystemMenuAuthorization findByUsernameAndSystemMenu(String username, SystemMenu systemMenu);

    SystemMenuAuthorization findByUsername(String username);
}
