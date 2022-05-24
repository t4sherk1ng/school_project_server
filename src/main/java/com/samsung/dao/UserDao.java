package com.samsung.dao;

import com.samsung.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    // SELECT * FROM genre WHERE name = ?
    User findByName(String name);
}