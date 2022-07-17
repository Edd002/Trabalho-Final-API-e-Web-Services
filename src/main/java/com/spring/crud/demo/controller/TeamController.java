package com.spring.crud.demo.controller;

import java.net.URI;
import java.util.List;

import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.dto.TeamDTO;
import com.spring.crud.demo.model.Team;
import com.spring.crud.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	private TeamService service;

	@LogObjectAfter
	@GetMapping
	public ResponseEntity<List<?>> findAll() {
		List<?> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@LogObjectAfter
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		Team team = service.findById(id);
		return ResponseEntity.ok().body(team);
	}

	@LogObjectBefore
	@LogObjectAfter
	@PostMapping
	public ResponseEntity<?> save(@RequestBody TeamDTO teamDTO) {
		Team savedTeam = service.save(teamDTO);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(savedTeam.getId())
				.toUri();
		return ResponseEntity.created(uri).body(savedTeam);
	}

	@LogObjectBefore
	@LogObjectAfter
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody TeamDTO teamDTO) {
		Team updatedTeam = service.update(id, teamDTO);
		return ResponseEntity.ok().body(updatedTeam);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		service.delete(id);
		return ResponseEntity.ok().body("Deleted successfully...!");
	}
}




