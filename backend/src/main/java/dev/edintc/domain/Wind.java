package dev.edintc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Wind {

    @JsonProperty("speed")
    private double speed;

    @JsonProperty("deg")
    private int deg;
}
