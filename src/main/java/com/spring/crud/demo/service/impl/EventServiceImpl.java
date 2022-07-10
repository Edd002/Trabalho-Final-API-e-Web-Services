package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Event;
import com.spring.crud.demo.repository.EventRepository;
import com.spring.crud.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    public List<Event> findAll() {
        return repository.findAll();
    }

    @Override
    public Event findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Event not found for id :: " + id));
    }

    @Override
    public Event save(Event event) {
        return repository.save(event);
    }

    @Override
    public Event update(int id, Event event) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("** Event not found for id :: " + id));

        event.setId(id);
        return repository.save(event);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(event -> repository.delete(event));
    }
}