package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}