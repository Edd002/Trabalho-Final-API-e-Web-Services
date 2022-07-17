package com.spring.crud.demo.service;

import com.spring.crud.demo.dto.TeamTournamentDTO;
import com.spring.crud.demo.dto.TournamentDTO;
import com.spring.crud.demo.model.TeamTournament;
import com.spring.crud.demo.model.Tournament;

import java.util.List;

public interface TournamentService {

    List<?> findAll();

    Tournament findById(int id);

    Tournament save(TournamentDTO tournamentDTO);

    Tournament update(int id, TournamentDTO tournamentDTO);

    TeamTournament updateTeamTournament(int id, TeamTournamentDTO teamTournamentDTO);

    void delete(int id);
}
