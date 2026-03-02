package com.spring.Eventmanagement.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.Eventmanagement.entity.Booking;
import com.spring.Eventmanagement.repository.BookingRepository;

@Repository
public class BookingDao {
	 @Autowired
	    private BookingRepository bookingRepository;

	 public Booking saveBooking(Booking booking) {
	        return bookingRepository.save(booking);
	    }

	    public Optional<Booking> findById(int id) {
	        return bookingRepository.findById(id);
	    }

	    public List<Booking> findAllBookings() {
	        return bookingRepository.findAll();
	    }
	    
	    public void deleteBooking(int id) {
	        bookingRepository.deleteById(id);
	    }

	    public List<Booking> findByBookingDate(LocalDate bookingDate) {
	        return bookingRepository.findByBookingDate(bookingDate);
	    }
}
