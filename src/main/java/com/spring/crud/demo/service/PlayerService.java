package com.spring.crud.demo.service;

import com.spring.crud.demo.model.Player;

import java.util.List;

public interface PlayerService {

    List<?> findAll();

    Player findById(int id);

    Player save(Player player);

	Player update(int id, Player player);

    void delete(int id);
}