package com.spring.Eventmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.Eventmanagement.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer>{
	List<Event> findByEventType(String eventType);

    List<Event> findByPriceLessThanEqual(Double price);
}
