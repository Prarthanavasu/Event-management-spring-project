package com.spring.Eventmanagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Payment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private int id;
    private Double amount;
    private String paymentMode;//  CASH, CARD, UPI 
    private String paymentStatus; // SUCCESS, FAILED, PENDING
    private LocalDateTime paymentDateTime;
    
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

}
