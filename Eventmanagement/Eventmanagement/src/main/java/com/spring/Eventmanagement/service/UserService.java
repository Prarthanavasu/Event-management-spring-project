package com.spring.Eventmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Eventmanagement.entity.User;
import com.spring.Eventmanagement.repository.UserRepository;


@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password,Long contact) {
    	
        User user = userRepository.findByEmailAndPasswordAndContact(email, password, contact);
        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
