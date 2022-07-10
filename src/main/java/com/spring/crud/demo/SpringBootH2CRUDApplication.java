package com.spring.crud.demo;

import com.spring.crud.demo.model.*;
import com.spring.crud.demo.repository.*;
import com.spring.crud.demo.utils.HelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories
public class SpringBootH2CRUDApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootH2CRUDApplication.class, args);
    }

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamMatchRepository teamMatchRepository;

    @Autowired
    private TeamTournamentRepository teamTournamentRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            List<Team> teams = teamRepository.findAll();
            if (teams.isEmpty()) {
                log.info("******* Inserting Teams to DB *******");
                teams = teamRepository.saveAll(HelperUtil.teamSupplier());
            } else {
                log.info("******* Teams stored in DB Size :: {}", teams.size());
                log.info("******* Teams stored in DB :: {}", teams);
            }

            List<Player> players = playerRepository.findAll();
            if (players.isEmpty()) {
                log.info("******* Inserting Players to DB *******");
                players = playerRepository.saveAll(HelperUtil.playerSupplier(teams));
            } else {
                log.info("******* Players stored in DB Size :: {}", players.size());
                log.info("******* Players stored in DB :: {}", players);
            }

            List<Tournament> tournaments = tournamentRepository.findAll();
            if (tournaments.isEmpty()) {
                log.info("******* Inserting Tournaments to DB *******");
                tournaments = tournamentRepository.saveAll(HelperUtil.tournamentSupplier(teams));
            } else {
                log.info("******* Tournaments stored in DB Size :: {}", tournaments.size());
                log.info("******* Tournaments stored in DB :: {}", tournaments);
            }

            List<Transfer> transfers = transferRepository.findAll();
            if (transfers.isEmpty()) {
                log.info("******* Inserting Transfers to DB *******");
                transfers = transferRepository.saveAll(HelperUtil.transferSupplier(teams));
            } else {
                log.info("******* Transfers stored in DB Size :: {}", transfers.size());
                log.info("******* Transfers stored in DB :: {}", transfers);
            }

            List<Match> matches = matchRepository.findAll();
            if (matches.isEmpty()) {
                log.info("******* Inserting Matches to DB *******");
                matches = matchRepository.saveAll(HelperUtil.matchSupplier(tournaments));
            } else {
                log.info("******* Matches stored in DB Size :: {}", matches.size());
                log.info("******* Matches stored in DB :: {}", matches);
            }

            List<Event> events = eventRepository.findAll();
            if (events.isEmpty()) {
                log.info("******* Inserting Events to DB *******");
                events = eventRepository.saveAll(HelperUtil.eventSupplier(matches));
            } else {
                log.info("******* Events stored in DB Size :: {}", events.size());
                log.info("******* Events stored in DB :: {}", events);
            }

            List<TeamMatch> teamMatches = teamMatchRepository.findAll();
            if (teamMatches.isEmpty()) {
                log.info("******* Inserting TeamMatches to DB *******");
                teamMatches = teamMatchRepository.saveAll(HelperUtil.teamMatchSupplier(teams, matches));
            } else {
                log.info("******* TeamMatches stored in DB Size :: {}", teamMatches.size());
                log.info("******* TeamMatches stored in DB :: {}", teamMatches);
            }

            List<TeamTournament> teamTournaments = teamTournamentRepository.findAll();
            if (teamTournaments.isEmpty()) {
                log.info("******* Inserting TeamTournaments to DB *******");
                teamTournaments = teamTournamentRepository.saveAll(HelperUtil.teamTournamentSupplier(teams, tournaments));
            } else {
                log.info("******* TeamTournaments stored in DB Size :: {}", teamTournaments.size());
                log.info("******* TeamTournaments stored in DB :: {}", teamTournaments);
            }
        };
    }
}