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
@Table(name = "Transfer")
@Entity(name = "Transfer")
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country")
    private String country;

    @Column(name = "value")
    private Double value;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "team_origin_id", foreignKey = @ForeignKey(name = "fk_transfer_team_origin"))
    private Team originTeam;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "team_destiny_id", foreignKey = @ForeignKey(name = "fk_transfer_team_destiny"))
    private Team destinyTeam;
}