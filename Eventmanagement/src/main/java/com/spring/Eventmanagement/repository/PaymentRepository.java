package com.spring.Eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Eventmanagement.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
