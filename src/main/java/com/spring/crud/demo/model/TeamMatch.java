package com.spring.crud.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Team_Match", uniqueConstraints = { @UniqueConstraint(name = "uk_match_team_match_team", columnNames = { "match", "team" }) })
@Entity(name = "Team_Match")
public class TeamMatch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "match_id", foreignKey = @ForeignKey(name = "fk_team_match_match"))
    private Match match;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "fk_team_match_team"))
    private Team team;
}
