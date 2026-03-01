package com.spring.Eventmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Eventmanagement.dao.UserDao;
import com.spring.Eventmanagement.dto.UserDto;
import com.spring.Eventmanagement.entity.User;


@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;

 // REGISTER
    public UserDto registerUser(UserDto dto) {

        Optional<User> existingUser = userDao.findByEmail(dto.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setContactNumber(dto.getContactNumber());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User saved = userDao.saveUser(user);

        dto.setUserId(saved.getUserId());
        return dto;
    }

    // LOGIN
    public UserDto loginUser(String email, String password) {

        Optional<User> optionalUser =
                userDao.findByEmail(email);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            if (user.getPassword().equals(password)) {

                UserDto dto = new UserDto();
                dto.setUserId(user.getUserId());
                dto.setUserName(user.getUserName());
                dto.setEmail(user.getEmail());
                dto.setContactNumber(user.getContactNumber());
                dto.setRole(user.getRole());

                return dto;

            } else {
                throw new RuntimeException("Invalid Password");
            }

        } else {
            throw new RuntimeException("User not found");
        }
    }

    // GET USER BY ID
    public UserDto getUserById(int id) {

        Optional<User> optional = userDao.findById(id);

        if (optional.isPresent()) {
            User user = optional.get();

            UserDto dto = new UserDto();
            dto.setUserId(user.getUserId());
            dto.setUserName(user.getUserName());   // updated
            dto.setEmail(user.getEmail());
            dto.setContactNumber(user.getContactNumber());
            dto.setPassword(user.getPassword());   // included
            dto.setRole(user.getRole());

            return dto;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    // GET ALL USERS
    public List<UserDto> getAllUsers() {

        List<User> users = userDao.findAllUsers();
        List<UserDto> dtos = new ArrayList<>();

        for (User user : users) {

            UserDto dto = new UserDto();
            dto.setUserId(user.getUserId());
            dto.setUserName(user.getUserName());   // updated
            dto.setEmail(user.getEmail());
            dto.setContactNumber(user.getContactNumber());
            dto.setPassword(user.getPassword());   // included
            dto.setRole(user.getRole());

            dtos.add(dto);
        }

        return dtos;
    }

    // DELETE
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
