package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.dto.EventDTO;
import com.spring.crud.demo.model.Event;
import com.spring.crud.demo.repository.EventRepository;
import com.spring.crud.demo.repository.MatchRepository;
import com.spring.crud.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new NotFoundException("** Event not found for id :: " + id));
    }

    @Override
    public Event save(EventDTO eventDTO) {
        Event event = Event.builder()
                .name(eventDTO.getName())
                .match(matchRepository.findById(eventDTO.getMatchId()).orElseThrow(() -> new NotFoundException("** Match not found for id :: " + eventDTO.getMatchId())))
                .build();
        return eventRepository.save(event);
    }

    @Override
    public Event update(int id, EventDTO eventDTO) {
        eventRepository.findById(id).orElseThrow(() -> new NotFoundException("** Event not found for id :: " + id));
        Event event = Event.builder()
                .id(id)
                .name(eventDTO.getName())
                .match(matchRepository.findById(eventDTO.getMatchId()).get())
                .build();
        return eventRepository.save(event);
    }

    @Override
    public void delete(int id) {
        eventRepository.findById(id).ifPresent(event -> eventRepository.delete(event));
    }
}