package com.spring.Eventmanagement.Dto;

import lombok.Data;

@Data
public class PaymentDto {
	private int id;
    private Double amount;
    private String paymentMethod;// cash card online
    private String paymentStatus; // payment failled payment success
    private int bookingId;
}
