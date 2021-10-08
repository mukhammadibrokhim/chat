package com.company.app.services;

import com.company.app.entities.User;
import com.company.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getusers(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

}
