package com.spring.crud.demo.service;

import com.spring.crud.demo.dto.MatchDTO;
import com.spring.crud.demo.model.Match;

import java.util.List;

public interface MatchService {

    List<?> findAll();

    Match findById(int id);

    Match save(MatchDTO matchDTO);

    Match update(int matchId, int teamMatchId, MatchDTO matchDTO);

    void delete(int id);
}