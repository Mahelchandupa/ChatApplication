package com.mahel.chatApp.service;

import com.mahel.chatApp.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user, Long id);

    void deleteUser(Long id);

    User getUser(Long id);

    List<User> getAllUsers();
}
