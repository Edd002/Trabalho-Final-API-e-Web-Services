package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMatchDTO {

    @JsonProperty("matchId")
    private int matchId;

    @JsonProperty("teamId")
    private int teamId;
}
