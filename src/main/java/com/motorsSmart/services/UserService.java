package com.motorsSmart.services;

import com.motorsSmart.domain.entities.User;
import com.motorsSmart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getByUserId(Long id){
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
