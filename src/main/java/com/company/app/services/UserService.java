package com.company.app.services;

import com.company.app.entities.User;
import com.company.app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User save(User user) {
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }

}
