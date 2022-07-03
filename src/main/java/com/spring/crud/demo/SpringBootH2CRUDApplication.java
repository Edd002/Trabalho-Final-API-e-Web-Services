package com.spring.crud.demo;

import com.spring.crud.demo.model.Team;
import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.model.Transfer;
import com.spring.crud.demo.repository.PlayerRepository;
import com.spring.crud.demo.repository.TeamRepository;
import com.spring.crud.demo.repository.TransferRepository;
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
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

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
                playerRepository.saveAll(HelperUtil.playerSupplier(teams));
            } else {
                log.info("******* Players stored in DB Size :: {}", players.size());
                log.info("******* Players stored in DB :: {}", players);
            }

            List<Transfer> transfers = transferRepository.findAll();
            if (transfers.isEmpty()) {
                log.info("******* Inserting Transfers to DB *******");
                transferRepository.saveAll(HelperUtil.transferSupplier(teams));
            } else {
                log.info("******* Transfers stored in DB Size :: {}", transfers.size());
                log.info("******* Transfers stored in DB :: {}", transfers);
            }
        };
    }
}