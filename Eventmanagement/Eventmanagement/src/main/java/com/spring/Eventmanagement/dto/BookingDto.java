package com.spring.Eventmanagement.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class BookingDto {
	private int bookingId;
    private LocalDate bookingDate;
    private LocalTime bookingTime;

    private int userId;  
    private int eventId;
}
