package dev.edintc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WeatherResponse {

    @JsonProperty("coord")
    private Map<String, Object> coord;

    @JsonProperty("weather")
    private List<Map<String, Object>> weather;

    @JsonProperty("main")
    private Map<String, Object> main;

    @JsonProperty("wind")
    private Map<String, Object> wind;

    @JsonProperty("clouds")
    private Map<String, Object> clouds;

    @JsonProperty("sys")
    private Map<String, Object> sys;

    @JsonProperty("name")
    private String name;
}
