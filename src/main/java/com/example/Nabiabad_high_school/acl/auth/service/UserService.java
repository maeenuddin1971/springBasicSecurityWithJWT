package com.example.Nabiabad_high_school.acl.auth.service;

import com.example.Nabiabad_high_school.acl.auth.entity.User;
import com.example.Nabiabad_high_school.acl.auth.repository.UserRepo;
import com.example.Nabiabad_high_school.exception.AlreadyExistsException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //creating user
    public User createUser(User user, HttpServletRequest request)
            throws AlreadyExistsException {

        User local = this.userRepo.findByUserName(user.getUserName());
        if(local!=null){
            System.out.println("User is already exists");
            throw new AlreadyExistsException("User already exists");
        }else{

            String siteUrl =getSiteURL(request)+"/user";
            String randomCode = RandomString.make(64);

            local = this.userRepo.save(user);

        }

        return local;
    }

    /** User created By System Only
     * This function use only for System Auto creation User
     * ***[Don't be use for another purpose]
     * */
    public User createUser(User user) throws Exception {

        User local = this.userRepo.findByUserName(user.getUserName());
        if(local!=null){
            System.out.println("User is already exists");
            throw new AlreadyExistsException("User already exists");
        }else{


            local = this.userRepo.save(user);
        }
        return local;
    }

    /**
     * This function Returns the current url of the project
     * This function use only verification link that user is received
     * */
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    //getting user by username
    public User getUserByUsername(String username) {
        User user = userRepo.findByUserName(username);
        return user;
    }

}
