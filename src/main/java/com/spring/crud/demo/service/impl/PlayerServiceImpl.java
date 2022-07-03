package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.repository.PlayerRepository;
import com.spring.crud.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public Player findById(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("** Player not found for id :: " + id));
    }

    @Override
    public Player save(Player player) {
        return repository.save(player);
    }

    @Override
    public Player update(int id, Player player) {
    	repository.findById(id).orElseThrow(() -> new NotFoundException("** Player not found for id :: " + id));
        
    	player.setId(id);
    	return repository.save(player);
    }

    @Override
    public void delete(int id) {
        repository.findById(id).ifPresent(Player -> repository.delete(Player));
    }
}