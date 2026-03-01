package com.spring.Eventmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Eventmanagement.entity.User;
import com.spring.Eventmanagement.repository.UserRepository;

@Repository
public class UserDao {

@Autowired
private UserRepository userRepository;

public User saveUser(User user) {
    return userRepository.save(user);
}

public Optional<User> findById(int id) {
    return userRepository.findById(id);
}

public List<User> findAllUsers() {
    return userRepository.findAll();
}

public void deleteUser(int id) {
    userRepository.deleteById(id);
}

public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
}
}
