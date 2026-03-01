package com.spring.Eventmanagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

 private int eventId;
 private String eventName;
 private String description;
 private Double price;
 private String eventType; // Wedding, Birthday ,party,concert

 @OneToMany(mappedBy = "event")
 @JsonIgnore
 private List<Booking> bookings;
}
