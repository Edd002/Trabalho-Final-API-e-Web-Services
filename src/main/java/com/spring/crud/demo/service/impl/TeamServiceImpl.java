package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.dto.TeamDTO;
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
	private TeamRepository teamRepository;

	@Override
	public List<Team> findAll() {
		return teamRepository.findAll();
	}

	@Override
	public Team findById(int id) {
		return teamRepository.findById(id).orElseThrow(() -> new NotFoundException("** Team not found for id :: " + id));
	}

	@Override
	public Team save(TeamDTO teamDTO) {
		Team team = Team.builder()
				.name(teamDTO.getName())
				.local(teamDTO.getLocal())
				.build();
		return teamRepository.save(team);
	}

	@Override
	public Team update(int id, TeamDTO teamDTO) {
		teamRepository.findById(id).orElseThrow(() -> new NotFoundException("** Team not found for id :: " + id));
		Team team = Team.builder()
				.id(id)
				.name(teamDTO.getName())
				.local(teamDTO.getLocal())
				.build();
		return teamRepository.save(team);
	}

	@Override
	public void delete(int id) {
		teamRepository.findById(id).ifPresent(team -> teamRepository.delete(team));
	}
}