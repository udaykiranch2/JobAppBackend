package com.uday.jobapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uday.jobapp.model.User;
import com.uday.jobapp.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user){
        
        user.setPassword(encoder.encode(user.getPassword()));
        
        return repo.save(user);
    }
    
}
