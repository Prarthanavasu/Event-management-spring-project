package com.spring.Eventmanagement.Dto;

import lombok.Data;

@Data
public class UserDto {

    private int userId;
    private String name;
    private String email;
    private String password;
    private long contactNumber;
}