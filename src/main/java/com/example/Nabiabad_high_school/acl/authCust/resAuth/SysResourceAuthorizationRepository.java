package com.example.Nabiabad_high_school.acl.authCust.resAuth;

import com.example.Nabiabad_high_school.acl.authCust.resDef.SysResourceDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface SysResourceAuthorizationRepository extends JpaRepository<SysResourceAuthorization,Long>, JpaSpecificationExecutor<SysResourceAuthorization> {
    List<SysResourceAuthorization> findBySystemResource(SysResourceDefinition resourceDefinitionInst);
    SysResourceAuthorization findBySystemResourceAndUsername(SysResourceDefinition definitionInst, String username);
    Optional<SysResourceAuthorization> findById(Long id);


    List<SysResourceAuthorization> findByUsername(String username);

    SysResourceAuthorization findByUsernameAndSystemResource(String username, SysResourceDefinition definitionInst);
}
