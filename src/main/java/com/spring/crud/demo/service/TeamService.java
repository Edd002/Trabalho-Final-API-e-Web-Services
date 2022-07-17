package com.spring.crud.demo.service;

import java.util.List;

import com.spring.crud.demo.dto.TeamDTO;
import com.spring.crud.demo.model.Team;

public interface TeamService {

	List<?> findAll();

	Team findById(int id);

	Team save(TeamDTO teamDTO);

	Team update(int id, TeamDTO teamDTO);

	void delete(int id);
}