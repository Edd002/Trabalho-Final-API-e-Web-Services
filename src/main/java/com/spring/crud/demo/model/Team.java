package com.spring.crud.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Team")
@Entity(name = "Team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "local")
    private String local;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = {CascadeType.ALL})
    private List<Player> players;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "originTeam", cascade = {CascadeType.ALL})
    private List<Transfer> teamsOrigin;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "destinyTeam", cascade = {CascadeType.ALL})
    private List<Transfer> teamsDestiny;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = {CascadeType.ALL})
    private List<TeamTournament> teamTournaments;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade = {CascadeType.ALL})
    private List<TeamMatch> teamMatches;
}