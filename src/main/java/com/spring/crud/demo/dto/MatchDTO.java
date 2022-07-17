package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("tournamentId")
    private int tournamentId;

    @JsonProperty("firstTeamId")
    private int firstTeamId;

    @JsonProperty("secondTeamId")
    private int secondTeamId;
}
