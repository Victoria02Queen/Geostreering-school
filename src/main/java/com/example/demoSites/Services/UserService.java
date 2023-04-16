package com.example.demoSites.Services;

import com.example.demoSites.models.Role;
import com.example.demoSites.models.User;
import com.example.demoSites.repo.RoleRepository;
import com.example.demoSites.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public User findUserById(long id){
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
    public User findUserByLogin(String login){
        User user = userRepository.findByLogin(login);
        return user;
    }
    public void addUser(String fullName, String position, String organization, String login, String password, String phone, String email){
        Role role = roleRepository.findByName("listener");
        User user = new User();
        user.setFullName(fullName);
        user.setPosition(position);
        user.setOrganization(organization);
        user.setLogin(login);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setRole(role);
        userRepository.save(user);
    }
}
