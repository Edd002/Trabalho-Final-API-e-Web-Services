package com.spring.crud.demo.service;

import com.spring.crud.demo.dto.EventDTO;
import com.spring.crud.demo.model.Event;

import java.util.List;

public interface EventService {

    List<?> findAll();

    Event findById(int id);

    Event save(EventDTO eventDTO);

    Event update(int id, EventDTO eventDTO);

    void delete(int id);
}