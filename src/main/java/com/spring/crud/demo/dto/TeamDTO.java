package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("local")
    private String local;

    @JsonProperty("matchId")
    private String matchId;
}
