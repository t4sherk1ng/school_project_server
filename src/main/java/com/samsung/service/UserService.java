package com.samsung.service;


import com.samsung.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    User insert(User user);

    @Transactional
    User update(int id, String name, String password, String phone, String city);

    List<User> getAll();

    User getById(int id);

    User getByName(String nickname);

    void deleteById(int id);
}