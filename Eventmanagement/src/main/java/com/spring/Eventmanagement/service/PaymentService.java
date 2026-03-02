package com.spring.Eventmanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Eventmanagement.dao.BookingDao;
import com.spring.Eventmanagement.dao.PaymentDao;
import com.spring.Eventmanagement.dto.PaymentDto;
import com.spring.Eventmanagement.entity.Booking;
import com.spring.Eventmanagement.entity.Payment;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private BookingDao bookingDao;

    // CREATE
    public PaymentDto createPayment(PaymentDto dto) {

        Booking booking = bookingDao.findById(dto.getBookingId())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setPaymentMode(dto.getPaymentMode());
        payment.setPaymentStatus(dto.getPaymentStatus());
        payment.setPaymentDateTime(LocalDateTime.now());
        payment.setBooking(booking);

        Payment saved = paymentDao.savePayment(payment);

        dto.setId(saved.getId());
        return dto;
    }

    // GET BY ID
    public PaymentDto getPaymentById(int id) {

        Payment payment = paymentDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        PaymentDto dto = new PaymentDto();
        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentMode(payment.getPaymentMode());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setBookingId(payment.getBooking().getBookingId());

        return dto;
    }

    // GET ALL
    public List<PaymentDto> getAllPayments() {

        List<Payment> payments = paymentDao.findAllPayments();
        List<PaymentDto> list = new ArrayList<>();

        for (Payment payment : payments) {
            PaymentDto dto = new PaymentDto();
            dto.setId(payment.getId());
            dto.setAmount(payment.getAmount());
            dto.setPaymentMode(payment.getPaymentMode());
            dto.setPaymentStatus(payment.getPaymentStatus());
            dto.setBookingId(payment.getBooking().getBookingId());
            list.add(dto);
        }

        return list;
    }

    // DELETE
    public void deletePayment(int id) {

            Payment payment = paymentDao.findById(id)
                    .orElseThrow(() -> new RuntimeException("Payment not found"));

            paymentDao.deletePayment(payment.getId());
    }

}