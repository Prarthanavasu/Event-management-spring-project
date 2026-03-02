package com.spring.Eventmanagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int userId;
    private String userName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private Long contactNumber;
    @JsonIgnore
    private String password;
    private String role; // USER / ADMIN
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Booking> bookings;
}
