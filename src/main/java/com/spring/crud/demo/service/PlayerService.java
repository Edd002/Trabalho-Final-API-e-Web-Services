package com.spring.crud.demo.service;

import com.spring.crud.demo.dto.PlayerDTO;
import com.spring.crud.demo.model.Player;

import java.util.List;

public interface PlayerService {

    List<?> findAll();

    Player findById(int id);

    Player save(PlayerDTO playerDTO);

	Player update(int id, PlayerDTO playerDTO);

    void delete(int id);
}