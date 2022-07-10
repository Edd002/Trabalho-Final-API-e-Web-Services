package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("birthdate")
    private String birthdate;

    @JsonProperty("country")
    private String country;

    @JsonProperty("teamId")
    private int teamId;
}
