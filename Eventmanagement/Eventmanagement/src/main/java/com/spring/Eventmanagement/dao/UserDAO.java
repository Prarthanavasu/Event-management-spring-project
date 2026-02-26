package com.spring.Eventmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Eventmanagement.entity.User;
import com.spring.Eventmanagement.repository.UserRepository;

@Repository
public class UserDAO {
	@Autowired
	UserRepository userRepository;
public User registerUser(User user) {
		User user2=userRepository.save(user);
		return user2;
	}
public List<User> findAllUser() {
	return userRepository.findAll();
}
}
