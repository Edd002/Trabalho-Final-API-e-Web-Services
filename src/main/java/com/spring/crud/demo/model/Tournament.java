package com.spring.crud.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Tournament")
@Entity(name = "Tournament")
public class Tournament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament", cascade = {CascadeType.ALL})
    private List<Match> matches;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tournament", cascade = {CascadeType.ALL})
    private List<TeamTournament> teamTournaments;
}
