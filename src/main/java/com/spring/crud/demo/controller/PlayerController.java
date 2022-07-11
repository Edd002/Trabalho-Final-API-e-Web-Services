package com.spring.crud.demo.controller;

import com.spring.crud.demo.annotation.LogObjectAfter;
import com.spring.crud.demo.annotation.LogObjectBefore;
import com.spring.crud.demo.dto.PlayerDTO;
import com.spring.crud.demo.model.Player;
import com.spring.crud.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @LogObjectAfter
    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        List<?> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @LogObjectAfter
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Player player = service.findById(id);
        return ResponseEntity.ok().body(player);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PlayerDTO playerDTO) {
        Player savedPlayer = service.save(playerDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
        		.path("/{id}")
        		.buildAndExpand(savedPlayer.getId())
        		.toUri();
        return ResponseEntity.created(uri).body(savedPlayer);
    }

    @LogObjectBefore
    @LogObjectAfter
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody PlayerDTO playerDTO) {
        Player updatedPlayer = service.update(id, playerDTO);
        return ResponseEntity.ok().body(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }
}