package com.spring.Eventmanagement.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingDto {

    private int id;
    private LocalDate bookingDate;
    private String status;

    private int userId;
    private int eventId;
}