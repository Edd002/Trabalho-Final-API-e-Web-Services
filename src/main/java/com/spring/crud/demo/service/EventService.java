package com.spring.crud.demo.service;

import com.spring.crud.demo.model.Event;

import java.util.List;

public interface EventService {

    List<?> findAll();

    Event findById(int id);

    Event save(Event event);

    Event update(int id, Event event);

    void delete(int id);
}