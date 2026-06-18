package com.skills.hub.service.impl;

import com.skills.hub.model.User;
import com.skills.hub.repository.UserRepository;
import com.skills.hub.service.UserService;
import org.springframework.stereotype.Service;

/*
=========================================================
WHAT IS THIS CLASS?
=========================================================

This class contains BUSINESS LOGIC for users.

 Controller calls this
 This class talks to repository

=========================================================
*/

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User registerUser(User user) {
        if (user == null || user.getEmail() == null) {
            return null;
        }
        User existing = userRepo.findByEmail(user.getEmail());
        if (existing != null) {
            return null;
        }
        return userRepo.save(user);
    }

    @Override
    public User login(String email, String password) {
        if (email == null || password == null) {
            return null;
        }
        User user = userRepo.findByEmail(email);
        if (user == null) {
            return null;
        }
        if (password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}