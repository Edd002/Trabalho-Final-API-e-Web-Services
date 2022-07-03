package com.spring.crud.demo.service;

import java.util.List;

import com.spring.crud.demo.model.Team;

public interface TeamService {

	List<?> findAll();

	Team findById(int id);

	Team save(Team team);

	Team update(int id, Team team);

	void delete(int id);
}