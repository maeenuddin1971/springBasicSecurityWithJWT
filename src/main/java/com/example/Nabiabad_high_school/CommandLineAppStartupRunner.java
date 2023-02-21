package com.example.Nabiabad_high_school;

import com.example.Nabiabad_high_school.acl.entity.Role;
import com.example.Nabiabad_high_school.acl.entity.User;
import com.example.Nabiabad_high_school.acl.repository.RoleRepo;
import com.example.Nabiabad_high_school.acl.repository.UserRepo;
import com.example.Nabiabad_high_school.acl.service.UserService;
import com.example.Nabiabad_high_school.modules.system.AppDefaultResourceDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private AppDefaultResourceDefService appDefaultResourceDefService;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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

        Role roleSuperAdmin=this.roleRepo.getRoleByRoleName("ROLE_SUPER_ADMIN");
        Role roleAdmin=this.roleRepo.getRoleByRoleName("ROLE_ADMIN");
        Role roleUser=this.roleRepo.getRoleByRoleName("ROLE_USER");


        /**
         * create super admin by system auto creation
         * */
        User superAdmin = this.userRepository.findByUserName("admin");

        Set<Role> rolesSuperAdminSet = new HashSet<>();
        rolesSuperAdminSet.add(roleSuperAdmin);

        if(superAdmin==null){

            superAdmin=new User();


            superAdmin.setUserName("admin");
            superAdmin.setPassword(this.bCryptPasswordEncoder.encode("1234"));
            superAdmin.setEmail("admin@gmail.com");
            superAdmin.setEnabled(true);

            superAdmin.setRoles(rolesSuperAdminSet);
            superAdmin.setAccountLocked(false);
            superAdmin.setAccountExpired(false);
            superAdmin.setPasswordExpired(false);


            superAdmin= this.userService.createUser(superAdmin);
            System.out.println("=========Super Admin Created========== "+superAdmin.getUserName());
        }
        /**
         * create admin by system auto creation
         * */
        User admin = this.userRepository.findByUserName("maeen");
        Set<Role> rolesAdminSet = new HashSet<>();
        rolesAdminSet.add(roleUser);

        if(admin==null){

            admin=new User();

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


            admin=this.userService.createUser(admin);
            System.out.println("==========Admin Created========== "+admin.getUserName());

        }
    }

    @Override
    public void run(String... args) throws Exception {
        this.createAppBasicRoles();
        this.createAppBasicUsers();
    }
}
