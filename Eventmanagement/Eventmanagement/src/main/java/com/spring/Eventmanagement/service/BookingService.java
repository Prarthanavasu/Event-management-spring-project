package com.spring.Eventmanagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Eventmanagement.dao.BookingDao;
import com.spring.Eventmanagement.dao.EventDao;
import com.spring.Eventmanagement.dao.UserDao;
import com.spring.Eventmanagement.dto.BookingDto;
import com.spring.Eventmanagement.entity.Booking;
import com.spring.Eventmanagement.entity.Event;
import com.spring.Eventmanagement.entity.User;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private EventDao eventDao;

    public BookingDto createBooking(BookingDto dto) {

        User user = userDao.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventDao.findEventById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Booking booking = new Booking();
        booking.setBookingDate(dto.getBookingDate());
        booking.setBookingTime(dto.getBookingTime());
        booking.setUser(user);
        booking.setEvent(event);

        Booking saved = bookingDao.saveBooking(booking);
        dto.setBookingId(saved.getBookingId());

        return dto;
    }

    public List<Booking> findAllBookings() {
        return bookingDao.findAllBookings();
    }

    public Booking getBookingById(int id) {
        return bookingDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
	
    public BookingDto updateBooking(int id, BookingDto dto) {

        Booking booking = bookingDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        User user = userDao.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Event event = eventDao.findEventById(dto.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        booking.setBookingDate(dto.getBookingDate());
        booking.setBookingTime(dto.getBookingTime());
        booking.setUser(user);
        booking.setEvent(event);

        Booking updated = bookingDao.saveBooking(booking);

        dto.setBookingId(updated.getBookingId());
        return dto;
    }

    public void deleteBooking(int id) {
        bookingDao.deleteBooking(id);
    }

    public List<BookingDto> getBookingsByDate(LocalDate date) {

        List<Booking> bookings = bookingDao.findByBookingDate(date);
        List<BookingDto> bookingDtos = new ArrayList<>();

        for (Booking booking : bookings) {

            BookingDto dto = new BookingDto();
            dto.setBookingId(booking.getBookingId());
            dto.setBookingDate(booking.getBookingDate());
            dto.setBookingTime(booking.getBookingTime());
            dto.setUserId(booking.getUser().getUserId());
            dto.setEventId(booking.getEvent().getEventId());

            bookingDtos.add(dto);
        }

        return bookingDtos;
    }
}