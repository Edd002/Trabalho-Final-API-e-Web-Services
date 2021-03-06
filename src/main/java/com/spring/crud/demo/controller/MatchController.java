package com.spring.crud.demo.controller;

import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.dto.EventDTO;
import com.spring.crud.demo.dto.MatchDTO;
import com.spring.crud.demo.enums.EventEnum;
import com.spring.crud.demo.model.Event;
import com.spring.crud.demo.model.Match;
import com.spring.crud.demo.service.EventService;
import com.spring.crud.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private EventService eventService;

    @LogObjectAfter
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = matchService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Match match = matchService.findById(id);
        return ResponseEntity.ok().body(match);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<?> save(@RequestBody MatchDTO matchDTO) {
        Match savedMatch = matchService.save(matchDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedMatch.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedMatch);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{matchId}/team-match/{teamMatchId}")
    public ResponseEntity<?> update(@PathVariable int matchId, @PathVariable int teamMatchId, @RequestBody MatchDTO matchDTO) {
        Match updatedMatch = matchService.update(matchId, teamMatchId, matchDTO);
        return ResponseEntity.ok().body(updatedMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        matchService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping("/{matchId}/events/begin-game")
    public ResponseEntity<?> beginGame(@PathVariable int matchId) {
        Event savedEvent = eventService.save(new EventDTO(EventEnum.BEGIN_GAME.getDescription(), matchId));

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEvent.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping("/{matchId}/events/goal")
    public ResponseEntity<?> goal(@PathVariable int matchId) {
        Event savedEvent = eventService.save(new EventDTO(EventEnum.GOAL.getDescription(), matchId));

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEvent.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping("/{matchId}/events/interval")
    public ResponseEntity<?> interval(@PathVariable int matchId) {
        Event savedEvent = eventService.save(new EventDTO(EventEnum.INTERVAL.getDescription(), matchId));

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEvent.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping("/{matchId}/events/add-time")
    public ResponseEntity<?> addTime(@PathVariable int matchId) {
        Event savedEvent = eventService.save(new EventDTO(EventEnum.ADD_TIME.getDescription(), matchId));

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEvent.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping("/{matchId}/events/replacement")
    public ResponseEntity<?> replacement(@PathVariable int matchId) {
        Event savedEvent = eventService.save(new EventDTO(EventEnum.REPLACEMENT.getDescription(), matchId));

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEvent.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping("/{matchId}/events/warning")
    public ResponseEntity<?> warning(@PathVariable int matchId) {
        Event savedEvent = eventService.save(new EventDTO(EventEnum.WARNING.getDescription(), matchId));

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEvent.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping("/{matchId}/events/end-game")
    public ResponseEntity<?> endGame(@PathVariable int matchId) {
        Event savedEvent = eventService.save(new EventDTO(EventEnum.END_GAME.getDescription(), matchId));

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEvent.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }
}