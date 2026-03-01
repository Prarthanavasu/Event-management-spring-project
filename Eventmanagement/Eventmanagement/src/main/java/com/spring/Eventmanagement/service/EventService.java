package com.spring.Eventmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Eventmanagement.dao.EventDao;
import com.spring.Eventmanagement.dto.EventDto;
import com.spring.Eventmanagement.entity.Event;

@Service
public class EventService {
	@Autowired
	private EventDao eventDao;
	
	// create
    public EventDto createEvent(EventDto eventDto) {

        Event event = new Event();
        event.setEventName(eventDto.getEventName());
        event.setDescription(eventDto.getDescription());
        event.setPrice(eventDto.getPrice());
        event.setEventType(eventDto.getEventType());

        Event savedEvent = eventDao.saveEvent(event);

        EventDto response = new EventDto();
        response.setEventId(savedEvent.getEventId());
        response.setEventName(savedEvent.getEventName());
        response.setDescription(savedEvent.getDescription());
        response.setPrice(savedEvent.getPrice());
        response.setEventType(savedEvent.getEventType());

        return response;
    }

    // GET event by id
    public EventDto getEventById(int id) {

        Optional<Event> optionalEvent = eventDao.findEventById(id);

        if (optionalEvent.isPresent()) {

            Event event = optionalEvent.get();

            EventDto dto = new EventDto();
            dto.setEventId(event.getEventId());
            dto.setEventName(event.getEventName());
            dto.setDescription(event.getDescription());
            dto.setPrice(event.getPrice());
            dto.setEventType(event.getEventType());

            return dto;
        } else {
            throw new RuntimeException("Event not found");
        }
    }
    
 // GET all event
    public List<EventDto> getAllEvents() {

        List<Event> events = eventDao.findAllEvents();
        List<EventDto> eventDtos = new ArrayList<>();

        for (Event event : events) {

            EventDto dto = new EventDto();
            dto.setEventId(event.getEventId());
            dto.setEventName(event.getEventName());
            dto.setDescription(event.getDescription());
            dto.setPrice(event.getPrice());
            dto.setEventType(event.getEventType());

            eventDtos.add(dto);
        }

        return eventDtos;
    }
    
 // UPDATE event
    public EventDto updateEvent(int id, EventDto eventDto) {

        Optional<Event> optionalEvent = eventDao.findEventById(id);

        if (optionalEvent.isPresent()) {

            Event event = optionalEvent.get();

            event.setEventName(eventDto.getEventName());
            event.setDescription(eventDto.getDescription());
            event.setPrice(eventDto.getPrice());
            event.setEventType(eventDto.getEventType());

            Event updatedEvent = eventDao.saveEvent(event);

            EventDto response = new EventDto();
            response.setEventId(updatedEvent.getEventId());
            response.setEventName(updatedEvent.getEventName());
            response.setDescription(updatedEvent.getDescription());
            response.setPrice(updatedEvent.getPrice());
            response.setEventType(updatedEvent.getEventType());

            return response;

        } else {
            throw new RuntimeException("Event not found");
        }
    }
    
    // DELETE event
    public void deleteEvent(int id) {
        eventDao.deleteEvent(id);
    }
    
 // search by type
    public List<EventDto> getEventsByType(String eventType) {

        List<Event> events = eventDao.findByEventType(eventType);
        List<EventDto> eventDtos = new ArrayList<>();

        for (Event event : events) {

            EventDto dto = new EventDto();
            dto.setEventId(event.getEventId());
            dto.setEventName(event.getEventName());
            dto.setDescription(event.getDescription());
            dto.setPrice(event.getPrice());
            dto.setEventType(event.getEventType());

            eventDtos.add(dto);
        }

        return eventDtos;
    }
 // filter by price
    public List<EventDto> getEventsByPrice(Double price) {

        List<Event> events = eventDao.findByPriceLessThanEqual(price);
        List<EventDto> eventDtos = new ArrayList<>();

        for (Event event : events) {

            EventDto dto = new EventDto();
            dto.setEventId(event.getEventId());
            dto.setEventName(event.getEventName());
            dto.setDescription(event.getDescription());
            dto.setPrice(event.getPrice());
            dto.setEventType(event.getEventType());

            eventDtos.add(dto);
        }

        return eventDtos;
    }
    
}