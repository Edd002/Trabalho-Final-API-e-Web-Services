package com.spring.crud.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Match")
@Entity(name = "Match")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tournament_id", foreignKey = @ForeignKey(name = "fk_match_tournament"))
    private Tournament tournament;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "match", cascade = {CascadeType.ALL})
    private List<Event> events;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "match", cascade = {CascadeType.ALL})
    private List<TeamMatch> teamMatches;
}
