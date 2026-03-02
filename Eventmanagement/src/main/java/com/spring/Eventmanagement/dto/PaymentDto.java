package com.spring.Eventmanagement.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class PaymentDto {
	private int id;
    private Double amount;
    private String paymentMode;      // CASH, CARD, UPI
    private String paymentStatus;    // SUCCESS, FAILED, PENDING
    private LocalDateTime paymentDateTime;

    private int bookingId; 
}
