package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TournamentDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("teamsIds")
    private List<Integer> teamsIds;
}
