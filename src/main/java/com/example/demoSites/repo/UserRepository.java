package com.example.demoSites.repo;

import com.example.demoSites.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

}
