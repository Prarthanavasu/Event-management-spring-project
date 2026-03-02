package com.spring.Eventmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Eventmanagement.entity.Payment;
import com.spring.Eventmanagement.repository.PaymentRepository;

@Repository
public class PaymentDao {
	 @Autowired
	    private PaymentRepository paymentRepository;

	    public Payment savePayment(Payment payment) {
	        return paymentRepository.save(payment);
	    }

	    public Optional<Payment> findById(int id) {
	        return paymentRepository.findById(id);
	    }

	    public List<Payment> findAllPayments() {
	        return paymentRepository.findAll();
	    }

	    public void deletePayment(int id) {
	        paymentRepository.deleteById(id);
	    } 
	    
}
