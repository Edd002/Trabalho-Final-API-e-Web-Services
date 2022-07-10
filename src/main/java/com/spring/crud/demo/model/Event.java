package com.spring.crud.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Event")
@Entity(name = "Event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "match_id", foreignKey = @ForeignKey(name = "fk_event_match"))
    private Match match;
}
