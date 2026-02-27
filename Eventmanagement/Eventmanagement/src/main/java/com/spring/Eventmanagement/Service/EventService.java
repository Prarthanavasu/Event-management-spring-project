package com.spring.Eventmanagement.Service;

import com.spring.Eventmanagement.Entity.Event;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class EventService {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long serviceId;
	  private String serviceName;   // Food, DJ, Decoration
	  private Double serviceCost;
	  @ManyToOne
	  @JoinColumn(name = "event_id")
	  private Event event;
}
