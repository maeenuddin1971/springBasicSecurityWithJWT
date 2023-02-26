package com.example.Nabiabad_high_school.acl.auth.springUser;

import com.example.Nabiabad_high_school.acl.auth.entity.User;
import com.example.Nabiabad_high_school.acl.auth.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);

        if(user == null) {
            throw new UsernameNotFoundException("No user found !!");
        }

        return new  UserDetailsImpl(user);
    }
}
