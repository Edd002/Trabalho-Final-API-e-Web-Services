package com.spring.crud.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferDTO {

    @JsonProperty("country")
    private String country;

    @JsonProperty("value")
    private Double value;

    @JsonProperty("originTeamId")
    private int originTeamId;

    @JsonProperty("destinyTeamId")
    private int destinyTeamId;
}
