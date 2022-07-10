package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Tournament;
import com.spring.crud.demo.repository.TournamentRepository;
import com.spring.crud.demo.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository repository;

    @Override
    public List<Tournament> findAll() {
        return repository.findAll();
    }

    @Override
    public Tournament findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Tournament not found for id :: " + id));
    }

    @Override
    public Tournament save(Tournament tournament) {
        return repository.save(tournament);
    }

    @Override
    public Tournament update(int id, Tournament tournament) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("** Tournament not found for id :: " + id));

        tournament.setId(id);
        return repository.save(tournament);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(tournament -> repository.delete(tournament));
    }
}