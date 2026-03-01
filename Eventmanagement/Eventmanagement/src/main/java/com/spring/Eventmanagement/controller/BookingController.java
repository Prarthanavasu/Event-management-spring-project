package com.spring.Eventmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Eventmanagement.dto.BookingDto;
import com.spring.Eventmanagement.entity.Booking;
import com.spring.Eventmanagement.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

   
    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto dto) {
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> findAllBookings() {
        return ResponseEntity.ok(bookingService.findAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(
            @PathVariable int id,
            @RequestBody BookingDto dto) {

        return ResponseEntity.ok(
                bookingService.updateBooking(id, dto)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {

        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }

    // SEARCH BY DATE
    @GetMapping("/date/{date}")
    public ResponseEntity<List<BookingDto>> getBookingsByDate(
            @PathVariable LocalDate date) {

        return ResponseEntity.ok(
                bookingService.getBookingsByDate(date)
        );
    }
}

