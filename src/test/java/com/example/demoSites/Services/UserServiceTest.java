package com.example.demoSites.Services;

import com.example.demoSites.models.Role;
import com.example.demoSites.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {
//    @Autowired
//    private UserService userService;
//    @Test
//    void findUserById() {
//        User user = new User("Ilia", "nachalnik", "Igirgi", "login", "122", "9688616168", "amaz@mail.ru", new Role("listener"), new HashSet<>(), new HashSet<>());
//        User userById = userService.findUserById(10000);
//        assertEquals(10000,userById.getId());
//        assertEquals("Ivanov", userById.getFullName());
//        assertEquals("boss", userById.getPosition());
//        assertEquals("OOO IGIRGI", userById.getOrganization());
//        assertEquals("89288763123", userById.getPhone());
//        assertEquals("akewd@mail.ru", userById.getEmail());
//        assertEquals("login1", userById.getLogin());
//        assertEquals("123", userById.getPassword());
//        assertEquals("admin", userById.getRole().getName());
//    }
//
//    @Test
//    void findUserByLogin() {
//    }
}