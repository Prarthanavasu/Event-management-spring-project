package com.spring.Eventmanagement.Entity;

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
    private String paymentMethod;// cash card online
    private String paymentStatus; // payment failled payment success
    
    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
