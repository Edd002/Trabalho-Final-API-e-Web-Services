package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.dto.PlayerDTO;
import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.repository.PlayerRepository;
import com.spring.crud.demo.repository.TeamRepository;
import com.spring.crud.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id).orElseThrow(() -> new NotFoundException("** Player not found for id :: " + id));
    }

    @Override
    public Player save(PlayerDTO playerDTO) {
        Player player;
        try {
            player = Player.builder()
                    .name(playerDTO.getName())
                    .birthdate(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(playerDTO.getBirthdate()))
                    .country(playerDTO.getCountry())
                    .team(teamRepository.findById(playerDTO.getTeamId()).get())
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return playerRepository.save(player);
    }

    @Override
    public Player update(int id, PlayerDTO playerDTO) {
    	playerRepository.findById(id).orElseThrow(() -> new NotFoundException("** Player not found for id :: " + id));

        Player player;
        try {
            player = Player.builder()
                    .id(id)
                    .name(playerDTO.getName())
                    .birthdate(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(playerDTO.getBirthdate()))
                    .country(playerDTO.getCountry())
                    .team(teamRepository.findById(playerDTO.getTeamId()).get())
                    .build();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    	return playerRepository.save(player);
    }

    @Override
    public void delete(int id) {
        playerRepository.findById(id).ifPresent(player -> playerRepository.delete(player));
    }
}