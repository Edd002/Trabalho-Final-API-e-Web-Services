package com.spring.crud.demo.service;

import com.spring.crud.demo.model.Tournament;

import java.util.List;

public interface TournamentService {

    List<?> findAll();

    Tournament findById(int id);

    Tournament save(Tournament tournament);

    Tournament update(int id, Tournament tournament);

    void delete(int id);
}
