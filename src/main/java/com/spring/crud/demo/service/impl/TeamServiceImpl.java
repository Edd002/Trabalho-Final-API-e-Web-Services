package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Team;
import com.spring.crud.demo.repository.TeamRepository;
import com.spring.crud.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository repository;

	@Override
	public List<Team> findAll() {
		return repository.findAll();
	}

	@Override
	public Team findById(int id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("** Team not found for id :: " + id));
	}

	@Override
	public Team save(Team team) {
		return repository.save(team);
	}

	@Override
	public Team update(int id, Team team) {
		repository.findById(id).orElseThrow(() -> new NotFoundException("** Team not found for id :: " + id));

		team.setId(id);
		return repository.save(team);
	}

	@Override
	public void delete(int id) {
		repository.findById(id).ifPresent(team -> repository.delete(team));
	}
}