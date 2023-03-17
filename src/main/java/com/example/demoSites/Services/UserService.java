package com.example.demoSites.Services;

import com.example.demoSites.models.User;
import com.example.demoSites.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User findUserById(long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
    public User findUserByLogin(String login){
        User user = userRepository.findByLogin(login);
        return user;
    }
}
