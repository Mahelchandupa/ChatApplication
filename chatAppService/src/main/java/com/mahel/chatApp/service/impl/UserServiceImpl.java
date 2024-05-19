package com.mahel.chatApp.service.impl;

import com.mahel.chatApp.entity.User;
import com.mahel.chatApp.repository.UserRepository;
import com.mahel.chatApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {

        Optional<User> user1 = userRepository.findById(id);

        if (user1.isEmpty()) {
            throw new RuntimeException("User not Found");
        }

        if (!Objects.equals(user1.get().getFirstName(), user.getFirstName())) {
            user1.get().setFirstName(user.getFirstName());
        }
        if (!Objects.equals(user1.get().getLastName(), user.getLastName())) {
            user1.get().setLastName(user.getLastName());
        }
        if (!Objects.equals(user1.get().getAddress(), user.getAddress())) {
            user1.get().setAddress(user.getAddress());
        }
        if (!Objects.equals(user1.get().getCity(), user.getCity())) {
            user1.get().setCity(user.getCity());
        }
        if (!Objects.equals(user1.get().getPhone(), user.getPhone())) {
            user1.get().setPhone(user.getPhone());
        }

        return userRepository.save(user1.get());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("Farmer not found");
        }

        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
