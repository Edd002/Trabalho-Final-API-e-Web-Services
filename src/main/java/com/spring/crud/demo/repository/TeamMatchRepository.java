package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.TeamMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamMatchRepository extends JpaRepository<TeamMatch, Integer> {
}
