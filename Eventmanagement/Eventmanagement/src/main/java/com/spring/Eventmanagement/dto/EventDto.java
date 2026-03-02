package com.spring.Eventmanagement.dto;

import lombok.Data;

@Data
public class EventDto {
	private int eventId;
	 private String eventName;
	 private String description;
	 private Double price;
	 private String eventType;
}

