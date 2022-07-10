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
@Table(name = "Team_Tournament")
@Entity(name = "Team_Tournament")
public class TeamTournament implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tournament_id", foreignKey = @ForeignKey(name = "fk_team_tournament_tournament"))
    private Tournament tournament;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "fk_team_tournament_team"))
    private Team team;
}
