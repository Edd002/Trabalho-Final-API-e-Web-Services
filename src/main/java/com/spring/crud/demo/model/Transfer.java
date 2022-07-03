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
@Entity
@Table
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "value")
    private Double value;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="team_origin_id")
    private Team originTeam;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="team_destiny_id")
    private Team destinyTeam;
}