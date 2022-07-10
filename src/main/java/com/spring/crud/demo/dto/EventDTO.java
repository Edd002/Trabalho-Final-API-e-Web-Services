package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("matchId")
    private int matchId;
}
