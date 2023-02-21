package com.example.Nabiabad_high_school.modules.system;

import com.example.Nabiabad_high_school.acl.entity.User;
import com.example.Nabiabad_high_school.acl.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppDefaultResourceDefService {
    @Autowired
    private UserRepo schoolUserRepo;


}
