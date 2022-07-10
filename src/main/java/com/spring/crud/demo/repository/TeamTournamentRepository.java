package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.TeamTournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamTournamentRepository extends JpaRepository<TeamTournament, Integer> {
}
