package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.dto.TeamTournamentDTO;
import com.spring.crud.demo.dto.TournamentDTO;
import com.spring.crud.demo.model.Team;
import com.spring.crud.demo.model.TeamTournament;
import com.spring.crud.demo.model.Tournament;
import com.spring.crud.demo.repository.TeamRepository;
import com.spring.crud.demo.repository.TeamTournamentRepository;
import com.spring.crud.demo.repository.TournamentRepository;
import com.spring.crud.demo.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamTournamentRepository teamTournamentRepository;

    @Override
    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament findById(int id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new NotFoundException("** Tournament not found for id :: " + id));
    }

    @Override
    public Tournament save(TournamentDTO tournamentDTO) {
        Tournament tournament = tournamentRepository.save(Tournament.builder()
                .name(tournamentDTO.getName())
                .build());

        List<TeamTournament> teamTournaments = new ArrayList<>();
        tournamentDTO.getTeamsIds().forEach(teamId ->
                teamTournaments.add(TeamTournament.builder()
                        .tournament(tournament)
                        .team(teamRepository.findById(teamId).get())
                        .build())
        );
        teamTournamentRepository.saveAll(teamTournaments);

        return tournamentRepository.save(tournament);
    }

    @Override
    public Tournament update(int id, TournamentDTO tournamentDTO) {
        tournamentRepository.findById(id).orElseThrow(() -> new NotFoundException("** Tournament not found for id :: " + id));

        Tournament tournament = tournamentRepository.save(Tournament.builder()
                .id(id)
                .name(tournamentDTO.getName())
                .build());

        return tournamentRepository.save(tournament);
    }

    @Override
    public TeamTournament updateTeamTournament(int id, TeamTournamentDTO teamTournamentDTO) {
        teamTournamentRepository.findById(id).orElseThrow(() -> new NotFoundException("** Team Tournament not found for id :: " + id));

        TeamTournament teamTournament = teamTournamentRepository.save(TeamTournament.builder()
                .id(id)
                .tournament(tournamentRepository.findById(id).orElseThrow(() -> new NotFoundException("** Tournament not found for id :: " + teamTournamentDTO.getTournamentId())))
                .team(teamRepository.findById(id).orElseThrow(() -> new NotFoundException("** Team not found for id :: " + teamTournamentDTO.getTeamId())))
                .build());

        return teamTournamentRepository.save(teamTournament);
    }

    @Override
    public void delete(int id) {
        tournamentRepository.findById(id).ifPresent(tournament -> tournamentRepository.delete(tournament));
    }
}