package com.example.Nabiabad_high_school;

import com.example.Nabiabad_high_school.acl.auth.entity.RequestUrl;
import com.example.Nabiabad_high_school.acl.auth.entity.Role;
import com.example.Nabiabad_high_school.acl.auth.entity.User;
import com.example.Nabiabad_high_school.acl.auth.entity.repository.AuthTypeRepository;
import com.example.Nabiabad_high_school.acl.auth.entity.settings.AuthType;
import com.example.Nabiabad_high_school.acl.auth.repository.RequestUrlRepository;
import com.example.Nabiabad_high_school.acl.auth.repository.RoleRepo;
import com.example.Nabiabad_high_school.acl.auth.repository.UserRepo;
import com.example.Nabiabad_high_school.acl.auth.service.UserService;
import com.example.Nabiabad_high_school.entity.system.SystemMenu;
import com.example.Nabiabad_high_school.entity.system.SystemMenuAuthorization;
import com.example.Nabiabad_high_school.repository.system.SystemMenuAuthorizationRepository;
import com.example.Nabiabad_high_school.repository.system.SystemMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SystemMenuRepository systemMenuRepository;

    @Autowired
    private RequestUrlRepository requestUrlRepository;

    @Autowired
    private SystemMenuAuthorizationRepository systemMenuAuthorizationRepository;

    @Autowired
    private AuthTypeRepository authTypeRepository;

    /**
     * Create Basic roles
     */
    public void createAppBasicRoles() {

        Role chkRoleExists = this.roleRepo.getRoleByRoleName("ROLE_SUPER_ADMIN");

        if (chkRoleExists == null) {
            Role roleInst1 = new Role("ROLE_SUPER_ADMIN", "");
            this.roleRepo.save(roleInst1);
        }

        chkRoleExists = this.roleRepo.getRoleByRoleName("ROLE_ADMIN");
        if (chkRoleExists == null) {
            Role roleInst2 = new Role("ROLE_ADMIN", "");
            this.roleRepo.save(roleInst2);
        }

        chkRoleExists = this.roleRepo.getRoleByRoleName("ROLE_USER");
        if (chkRoleExists == null) {
            Role roleInst3 = new Role("ROLE_USER", "");
            this.roleRepo.save(roleInst3);
        }
    }

    public void createAppBasicUsers() throws Exception {

        Role roleSuperAdmin = this.roleRepo.getRoleByRoleName("ROLE_SUPER_ADMIN");
        Role roleAdmin = this.roleRepo.getRoleByRoleName("ROLE_ADMIN");
        Role roleUser = this.roleRepo.getRoleByRoleName("ROLE_USER");


        /**
         * create super admin by system auto creation
         * */
        User superAdmin = this.userRepository.findByUserName("admin");

        Set<Role> rolesSuperAdminSet = new HashSet<>();
        rolesSuperAdminSet.add(roleSuperAdmin);

        if (superAdmin == null) {

            superAdmin = new User();


            superAdmin.setUserName("admin");
            superAdmin.setPassword(this.bCryptPasswordEncoder.encode("1234"));
            superAdmin.setEmail("admin@gmail.com");
            superAdmin.setEnabled(true);

            superAdmin.setRoles(rolesSuperAdminSet);
            superAdmin.setAccountLocked(false);
            superAdmin.setAccountExpired(false);
            superAdmin.setPasswordExpired(false);


            superAdmin = this.userService.createUser(superAdmin);
            System.out.println("=========Super Admin Created========== " + superAdmin.getUserName());
        }
        /**
         * create admin by system auto creation
         * */
        User admin = this.userRepository.findByUserName("maeen");
        Set<Role> rolesAdminSet = new HashSet<>();
        rolesAdminSet.add(roleUser);

        if (admin == null) {

            admin = new User();

            admin.setUserName("maeen");
            admin.setPassword(this.bCryptPasswordEncoder.encode("1234"));
            admin.setEmail("maeen1971@gmail.com");
            admin.setEnabled(true);
            admin.setRoles(rolesAdminSet);


            superAdmin.setAccountLocked(false);
            superAdmin.setAccountExpired(false);
            superAdmin.setPasswordExpired(false);

            /** Also Super Admin */
            admin.setRoles(rolesSuperAdminSet);


            admin = this.userService.createUser(admin);
            System.out.println("==========Admin Created========== " + admin.getUserName());

        }
    }


    /***System Menu Creating============*/
    public void createSystemMenu() {

        // SYSTEM  Generate // -----------------------------------------------------------------------------------------
        SystemMenu menuInst_System;
        boolean exist = systemMenuRepository.existsByCode("SYSTEM");
        if (!exist) {
            menuInst_System = new SystemMenu("SYSTEM", "System", "/systemRootMenu", "<i class=\"nav-icon fab fa-windows\"></i>", true, 100, true, "/systemRootMenu", "System", null);
            menuInst_System = systemMenuRepository.save(menuInst_System);
        } else {
            menuInst_System = systemMenuRepository.findByCode("SYSTEM");
        }

        // Set to Request URL Map
        RequestUrl requestUrlInst = requestUrlRepository.getByUrlPath("/systemRootMenu#");
        if (requestUrlInst == null) {
            requestUrlInst = new RequestUrl("/systemRootMenu#", "ROLE_USER", null, new Date(), "SYSTEM");
            requestUrlRepository.save(requestUrlInst);
        }


        SystemMenu menuInst_User = systemMenuRepository.getByCode("AUTH_USER");
        if (menuInst_User == null) {
            SystemMenu menuInst_user = new SystemMenu("AUTH_USER", "User", "/user", "", true, 110, true, "/user", "System", null);
            menuInst_user = systemMenuRepository.save(menuInst_user);
            menuInst_user.setParentMenu(menuInst_System);
            systemMenuRepository.save(menuInst_user);
        }
        // Set to Request URL Map
        requestUrlInst = requestUrlRepository.getByUrlPath("/user");
        if (requestUrlInst == null) {
            requestUrlInst = new RequestUrl("/user/index", "ROLE_USER", null, new Date(), "SYSTEM");
            requestUrlRepository.save(requestUrlInst);
        }


        SystemMenu menuInst_Role = systemMenuRepository.getByCode("AUTH_ROLE");
        if (menuInst_Role == null) {
            SystemMenu menuInst_role = new SystemMenu("AUTH_ROLE", "Role", "/role", "", true, 120, true, "/role", "System", null);
            menuInst_role = systemMenuRepository.save(menuInst_role);
            menuInst_role.setParentMenu(menuInst_System);
            systemMenuRepository.save(menuInst_role);
        }
        // Set to Request URL Map
        requestUrlInst = requestUrlRepository.getByUrlPath("/role");
        if (requestUrlInst == null) {
            requestUrlInst = new RequestUrl("/role/index", "ROLE_USER", null, new Date(), "SYSTEM");
            requestUrlRepository.save(requestUrlInst);
        }


        SystemMenu menuInst_UserRoleChk = systemMenuRepository.getByCode("AUTH_USER_ROLE");
        if (menuInst_UserRoleChk == null) {
            SystemMenu menuInst_UserRole = new SystemMenu("AUTH_USER_ROLE", "User Role", "/userrole", "", true, 130, true, "/userrole", "System", null);
            menuInst_UserRole = systemMenuRepository.save(menuInst_UserRole);
            menuInst_UserRole.setParentMenu(menuInst_System);
            systemMenuRepository.save(menuInst_UserRole);
        }
        // Set to Request URL Map
        requestUrlInst = requestUrlRepository.getByUrlPath("/userrole");
        if (requestUrlInst == null) {
            requestUrlInst = new RequestUrl("/userrole/index", "ROLE_USER", null, new Date(), "SYSTEM");
            requestUrlRepository.save(requestUrlInst);
        }


        SystemMenu menuInst_RequestMapChk = systemMenuRepository.getByCode("AUTH_REQUEST_MAP");
        if (menuInst_RequestMapChk == null) {
            SystemMenu menuInst_RequestMap = new SystemMenu("AUTH_REQUEST_MAP", "Request Map", "/requesturl", "", true, 140, true, "/requesturl", "System", null);
            menuInst_RequestMap = systemMenuRepository.save(menuInst_RequestMap);
            menuInst_RequestMap.setParentMenu(menuInst_System);
            systemMenuRepository.save(menuInst_RequestMap);
        }
        // Set to Request URL Map
        requestUrlInst = requestUrlRepository.getByUrlPath("/requesturl");
        if (requestUrlInst == null) {
            requestUrlInst = new RequestUrl("/requesturl/index", "ROLE_USER", null, new Date(), "SYSTEM");
            requestUrlRepository.save(requestUrlInst);
        }


        SystemMenu menuInst_MenuDefChk = systemMenuRepository.getByCode("SYS_MENU_DEF");
        if (menuInst_MenuDefChk == null) {
            SystemMenu menuInst_MenuDef = new SystemMenu("SYS_MENU_DEF", "Menu Definition", "/menu", "", true, 150, true, "/menu", "System", null);
            menuInst_MenuDef = systemMenuRepository.save(menuInst_MenuDef);
            menuInst_MenuDef.setParentMenu(menuInst_System);
            systemMenuRepository.save(menuInst_MenuDef);
        }
        // Set to Request URL Map
        requestUrlInst = requestUrlRepository.getByUrlPath("/menu");
        if (requestUrlInst == null) {
            requestUrlInst = new RequestUrl("/menu", "ROLE_USER", null, new Date(), "SYSTEM");
            requestUrlRepository.save(requestUrlInst);
        }


        SystemMenu menuInst_sysMenuAuthorizationChk = systemMenuRepository.getByCode("SYS_MENU_AUTH");
        if (menuInst_sysMenuAuthorizationChk == null) {
            SystemMenu menuInst_sysMenuAuthorization = new SystemMenu("SYS_MENU_AUTH", "Menu Authorization", "/menu/auth", "", true, 155, true, "/menu/auth", "System", null);
            menuInst_sysMenuAuthorization = systemMenuRepository.save(menuInst_sysMenuAuthorization);
            menuInst_sysMenuAuthorization.setParentMenu(menuInst_System);
            systemMenuRepository.save(menuInst_sysMenuAuthorization);
        }

        //Set to Request URL Map
        requestUrlInst = requestUrlRepository.getByUrlPath("/menu/auth");
        if (requestUrlInst == null) {
            requestUrlInst = new RequestUrl("/menu/auth", "ROLE_USER", null, new Date(), "SYSTEM");
            requestUrlRepository.save(requestUrlInst);
        }
    }

    /**
     * System Menu authorization
     */
    public void createSystemMenuAuthorization() {
        /**System menu authorization*/
        SystemMenu menuInst_System = systemMenuRepository.findByCode("SYSTEM");
        SystemMenuAuthorization systemMenuAuthorizationInst = this.systemMenuAuthorizationRepository.findBySystemMenu(menuInst_System);
        if (systemMenuAuthorizationInst == null) {
            User userGeneral = this.userRepository.getUserByUserName("system");
            systemMenuAuthorizationInst = new SystemMenuAuthorization("SYSTEM", null, userGeneral.getUserName(), menuInst_System, true, 101);
            systemMenuAuthorizationRepository.save(systemMenuAuthorizationInst);
        }
        //Set to Auth user  SystemMenuAuthorization
        SystemMenu menuInst_User = systemMenuRepository.getByCode("AUTH_USER");
        systemMenuAuthorizationInst = this.systemMenuAuthorizationRepository.findBySystemMenu(menuInst_User);
        if (systemMenuAuthorizationInst == null) {
            User userGeneral = this.userRepository.getUserByUserName("system");
            systemMenuAuthorizationInst = new SystemMenuAuthorization("AUTH_USER", null, userGeneral.getUserName(), menuInst_User, true, 102);
            systemMenuAuthorizationRepository.save(systemMenuAuthorizationInst);
        }
        //Set to SystemMenuAuthorization
        SystemMenu menuInst_Role = systemMenuRepository.getByCode("AUTH_ROLE");
        systemMenuAuthorizationInst = this.systemMenuAuthorizationRepository.findBySystemMenu(menuInst_Role);
        if (systemMenuAuthorizationInst == null) {
            User userGeneral = this.userRepository.getUserByUserName("system");
            systemMenuAuthorizationInst = new SystemMenuAuthorization("AUTH_ROLE", null, userGeneral.getUserName(), menuInst_Role, true, 103);
            systemMenuAuthorizationRepository.save(systemMenuAuthorizationInst);
        }
        //Set to SystemMenuAuthorization
        SystemMenu menuInst_UserRoleChk = systemMenuRepository.getByCode("AUTH_USER_ROLE");
        systemMenuAuthorizationInst = this.systemMenuAuthorizationRepository.findBySystemMenu(menuInst_UserRoleChk);
        if (systemMenuAuthorizationInst == null) {
            User userGeneral = this.userRepository.getUserByUserName("system");
            systemMenuAuthorizationInst = new SystemMenuAuthorization("AUTH_USER_ROLE", null, userGeneral.getUserName(), menuInst_UserRoleChk, true, 104);
            systemMenuAuthorizationRepository.save(systemMenuAuthorizationInst);
        }
        //Set to SystemMenuAuthorization
        SystemMenu menuInst_RequestMapChk = systemMenuRepository.getByCode("AUTH_REQUEST_MAP");
        systemMenuAuthorizationInst = this.systemMenuAuthorizationRepository.findBySystemMenu(menuInst_RequestMapChk);
        if (systemMenuAuthorizationInst == null) {
            User userGeneral = this.userRepository.getUserByUserName("system");
            systemMenuAuthorizationInst = new SystemMenuAuthorization("AUTH_REQUEST_MAP", null, userGeneral.getUserName(), menuInst_RequestMapChk, true, 105);
            systemMenuAuthorizationRepository.save(systemMenuAuthorizationInst);
        }
        //Set to SystemMenuAuthorization

        SystemMenu menuInst_MenuDefChk = systemMenuRepository.getByCode("SYS_MENU_DEF");
        systemMenuAuthorizationInst = this.systemMenuAuthorizationRepository.findBySystemMenu(menuInst_MenuDefChk);
        if (systemMenuAuthorizationInst == null) {
            User userGeneral = this.userRepository.getUserByUserName("system");
            systemMenuAuthorizationInst = new SystemMenuAuthorization("SYS_MENU_DEF", null, userGeneral.getUserName(), menuInst_MenuDefChk, true, 1056);
            systemMenuAuthorizationRepository.save(systemMenuAuthorizationInst);
        }
        //Set to SystemMenuAuthorization
        SystemMenu menuInst_sysMenuAuthorizationChk = systemMenuRepository.getByCode("SYS_MENU_AUTH");
        systemMenuAuthorizationInst = this.systemMenuAuthorizationRepository.findBySystemMenu(menuInst_sysMenuAuthorizationChk);
        if (systemMenuAuthorizationInst == null) {
            User userGeneral = this.userRepository.getUserByUserName("system");
            systemMenuAuthorizationInst = new SystemMenuAuthorization("SYS_MENU_AUTH", null, userGeneral.getUserName(), menuInst_sysMenuAuthorizationChk, true, 107);
            systemMenuAuthorizationRepository.save(systemMenuAuthorizationInst);
        }

    }

    /**
     * Set Auth Type
     */
    public void setAuthType() {
        AuthType authTypeChk = this.authTypeRepository.findByAuthType("URL_BASED");
        AuthType authTypeChk2 = this.authTypeRepository.findByAuthType("ROLE_BASED");
        if (authTypeChk == null && authTypeChk2 == null) {
            AuthType authType = new AuthType();
            authType.setAuthType("URL_BASED");
            this.authTypeRepository.save(authType);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        this.createAppBasicRoles();
        this.createAppBasicUsers();

        this.setAuthType();
    }
}
