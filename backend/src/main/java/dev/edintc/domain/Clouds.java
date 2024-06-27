package dev.edintc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Clouds {

    @JsonProperty("all")
    private int all;
}
