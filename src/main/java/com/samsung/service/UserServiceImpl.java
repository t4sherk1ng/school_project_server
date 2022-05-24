package com.samsung.service;

import com.samsung.dao.UserDao;
import com.samsung.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    @Transactional
    public User insert(User user) {
        return userDao.save(user);
    }

    @Override
    @Transactional
    public User update(int id, String name, String password, String phone, String city) {
        User user = User.builder()
                .id(id)
                .name(name)
                .password(password)
                .phone(phone)
                .city(city)
                .build();
        return userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public User getByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }
}
