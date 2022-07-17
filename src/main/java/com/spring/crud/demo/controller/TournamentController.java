package com.spring.crud.demo.controller;

import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.dto.TeamTournamentDTO;
import com.spring.crud.demo.dto.TournamentDTO;
import com.spring.crud.demo.model.TeamTournament;
import com.spring.crud.demo.model.Tournament;
import com.spring.crud.demo.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService service;

    @LogObjectAfter
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Tournament tournament = service.findById(id);
        return ResponseEntity.ok().body(tournament);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<?> save(@RequestBody TournamentDTO tournamentDTO) {
        Tournament savedTournament = service.save(tournamentDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedTournament.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedTournament);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody TournamentDTO tournamentDTO) {
        Tournament updatedTournament = service.update(id, tournamentDTO);
        return ResponseEntity.ok().body(updatedTournament);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/update-team-tournament/{id}")
    public ResponseEntity<?> updateTeamTournament(@PathVariable int id, @RequestBody TeamTournamentDTO teamTournamentDTO) {
        TeamTournament updatedTeamTournament = service.updateTeamTournament(id, teamTournamentDTO);
        return ResponseEntity.ok().body(updatedTeamTournament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}