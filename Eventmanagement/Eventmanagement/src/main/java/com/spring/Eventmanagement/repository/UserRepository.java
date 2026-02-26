package com.spring.Eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Eventmanagement.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
    User findByEmailAndPasswordAndContact(String email, String password,Long contact);
}
