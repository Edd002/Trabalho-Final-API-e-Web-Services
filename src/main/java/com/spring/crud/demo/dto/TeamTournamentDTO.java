package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamTournamentDTO {

    @JsonProperty("tournamentId")
    private int tournamentId;

    @JsonProperty("teamId")
    private int teamId;
}
