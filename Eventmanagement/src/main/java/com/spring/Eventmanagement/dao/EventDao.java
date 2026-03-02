package com.spring.Eventmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.Eventmanagement.repository.EventRepository;
import com.spring.Eventmanagement.entity.Event;

@Repository
public class EventDao {
	@Autowired
    private EventRepository eventRepository;
	
	public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> findEventById(int id) {
        return eventRepository.findById(id);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }

    public List<Event> findByEventType(String eventType) {
        return eventRepository.findByEventType(eventType);
    }
    public List<Event> findByPriceLessThanEqual(Double price) {
        return eventRepository.findByPriceLessThanEqual(price);
    }
}