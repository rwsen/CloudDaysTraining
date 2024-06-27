package dev.edintc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coord {

    @JsonProperty("lon")
    private double lon;

    @JsonProperty("lat")
    private double lat;
}
