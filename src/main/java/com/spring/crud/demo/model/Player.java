package com.spring.crud.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Player")
@Entity(name = "Player")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "birthdate")
    @JsonProperty("birthdate")
    private Date birthdate;

    @Column(name = "country")
    @JsonProperty("country")
    private String country;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "fk_player_team"))
    private Team team;
}