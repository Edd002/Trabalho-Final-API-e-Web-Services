package com.spring.crud.demo.service;

import com.spring.crud.demo.model.Match;

import java.util.List;

public interface MatchService {

    List<?> findAll();

    Match findById(int id);

    Match save(Match match);

    Match update(int id, Match match);

    void delete(int id);
}