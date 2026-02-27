package com.spring.Eventmanagement.Dto;

import lombok.Data;

@Data
public class EventDto {

    private int eventId;
    private String eventName;
    private String description;
   // private String location;
    private Double price;
    private String eventType;
}
