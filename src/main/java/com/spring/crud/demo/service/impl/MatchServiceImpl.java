package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Match;
import com.spring.crud.demo.repository.MatchRepository;
import com.spring.crud.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository repository;

    @Override
    public List<Match> findAll() {
        return repository.findAll();
    }

    @Override
    public Match findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Match not found for id :: " + id));
    }

    @Override
    public Match save(Match match) {
        return repository.save(match);
    }

    @Override
    public Match update(int id, Match match) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("** Match not found for id :: " + id));

        match.setId(id);
        return repository.save(match);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(match -> repository.delete(match));
    }
}