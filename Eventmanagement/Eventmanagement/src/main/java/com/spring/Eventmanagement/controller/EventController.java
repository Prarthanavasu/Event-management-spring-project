package com.spring.Eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Eventmanagement.dto.EventDto;
import com.spring.Eventmanagement.service.EventService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/events")
public class EventController {
	 @Autowired
	  private EventService eventService;
	 
	    // create
	    @PostMapping //http://localhost:8080/api/events
	    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
	    EventDto savedEvent = eventService.createEvent(eventDto);
        return ResponseEntity.ok(savedEvent);
	    }
	    // GET by id
	    @GetMapping("/{id}") //http://localhost:8080/api/events/1
	    public ResponseEntity<EventDto> getEventById(@PathVariable int id) {
	        EventDto event = eventService.getEventById(id);
	        return ResponseEntity.ok(event);
	    }
	    
	    // GET all event
	    @GetMapping("/all") //http://localhost:8080/api/events/all
	    public ResponseEntity<List<EventDto>> getAllEvents() {
	        List<EventDto> events = eventService.getAllEvents();
	        return ResponseEntity.ok(events);
	    }
	    
	 // update
	    @PutMapping("/{id}")  //http://localhost:8080/api/events/1
	    public ResponseEntity<EventDto> updateEvent(
	            @PathVariable int id,
	            @RequestBody EventDto eventDto) {

	        EventDto updatedEvent = eventService.updateEvent(id, eventDto);
	        return ResponseEntity.ok(updatedEvent);
	    }
	 // delete
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEvent(@PathVariable int id) {
	        eventService.deleteEvent(id);
	        return ResponseEntity.ok("Event deleted successfully");
	    }
	 // search based on type
	    @GetMapping("/type/{eventType}") //http://localhost:8080/api/events/type/Marriage
	    public ResponseEntity<List<EventDto>> getEventsByType(@PathVariable String eventType) {
	        List<EventDto> events = eventService.getEventsByType(eventType);
	        return ResponseEntity.ok(events);
	    }
   
	 // search by price
	    @GetMapping("/price/{price}")  //http://localhost:8080/api/events/price/10000
	    public ResponseEntity<List<EventDto>> getEventsByPrice(@PathVariable Double price) {
	        List<EventDto> events = eventService.getEventsByPrice(price);
	        return ResponseEntity.ok(events);   
	 
}
}