package com.spring.Eventmanagement.dto;

import lombok.Data;

@Data
public class UserDto {
	private int userId;
	private String userName;
	private String email;
	private String password;
	private Long contactNumber;
	private String role;
}
