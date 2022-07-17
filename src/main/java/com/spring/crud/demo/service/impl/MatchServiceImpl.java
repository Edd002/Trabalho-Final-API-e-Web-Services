package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.dto.MatchDTO;
import com.spring.crud.demo.dto.TeamMatchDTO;
import com.spring.crud.demo.model.Match;
import com.spring.crud.demo.model.Team;
import com.spring.crud.demo.model.TeamMatch;
import com.spring.crud.demo.repository.MatchRepository;
import com.spring.crud.demo.repository.TeamMatchRepository;
import com.spring.crud.demo.repository.TeamRepository;
import com.spring.crud.demo.repository.TournamentRepository;
import com.spring.crud.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMatchRepository teamMatchRepository;

    @Override
    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    @Override
    public Match findById(int id) {
        return matchRepository.findById(id).orElseThrow(() -> new NotFoundException("** Match not found for id :: " + id));
    }

    @Override
    public Match save(MatchDTO matchDTO) {
        Match match = matchRepository.save(Match.builder()
                .name(matchDTO.getName())
                .tournament(tournamentRepository.findById(matchDTO.getTournamentId()).get())
                .build());

        teamMatchRepository.save(TeamMatch.builder()
                .match(match)
                .team(teamRepository.findById(matchDTO.getFirstTeamId()).orElseThrow(() -> new NotFoundException("** Team not found for id :: " + matchDTO.getFirstTeamId())))
                .build());

        teamMatchRepository.save(TeamMatch.builder()
                .match(match)
                .team(teamRepository.findById(matchDTO.getSecondTeamId()).orElseThrow(() -> new NotFoundException("** Team not found for id :: " + matchDTO.getSecondTeamId())))
                .build());

        return matchRepository.findById(match.getId()).get();
    }

    @Override
    public Match update(int matchId, int teamMatchId, MatchDTO matchDTO) {
        matchRepository.findById(matchId).orElseThrow(() -> new NotFoundException("** Match not found for id :: " + matchId));

        Match match = matchRepository.save(Match.builder()
                .id(matchId)
                .name(matchDTO.getName())
                .tournament(tournamentRepository.findById(matchDTO.getTournamentId()).get())
                .build());

        teamMatchRepository.save(TeamMatch.builder()
                .id(teamMatchId)
                .match(match)
                .team(teamRepository.findById(matchDTO.getFirstTeamId()).orElseThrow(() -> new NotFoundException("** First Team not found for id :: " + matchDTO.getFirstTeamId())))
                .build());

        teamMatchRepository.save(TeamMatch.builder()
                .id(teamMatchId)
                .match(match)
                .team(teamRepository.findById(matchDTO.getSecondTeamId()).orElseThrow(() -> new NotFoundException("** Second Team not found for id :: " + matchDTO.getSecondTeamId())))
                .build());

        return matchRepository.findById(match.getId()).get();
    }

    @Override
    public void delete(int id) {
        matchRepository.findById(id).ifPresent(match -> matchRepository.delete(match));
    }
}