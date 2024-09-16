package com.ms.user.service;

import com.ms.user.producers.UserProducers;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.user.models.UserModel;
import com.ms.user.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    
    @Autowired
    final UserRepository userRepository;
    final UserProducers userProducers;


    public UserService(UserRepository userRepository, UserProducers userProducers){
        this.userRepository = userRepository;
        this.userProducers = userProducers;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        userRepository.save(userModel);
        userProducers.publishMessageEmail(userModel);
        return userModel;
    }
    public List<UserModel> listAllUser() {
        List<UserModel> users = userRepository.findAll();
        return users;
    }
    public UserModel getUserById(UUID id) {
        var user = userRepository.findById(id).orElse(null);
        return user;
    }
}
