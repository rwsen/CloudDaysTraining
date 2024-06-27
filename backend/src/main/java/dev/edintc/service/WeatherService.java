package dev.edintc.service;

import dev.edintc.domain.WeatherResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/data/2.5/weather")
@RegisterRestClient(configKey = "weather-api")
public interface WeatherService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    WeatherResponse getWeather(@QueryParam("q") String city,
                               @QueryParam("appid") String apiKey,
                               @QueryParam("units") String units);

    @GET
    @Path("/old")
    @Produces(MediaType.APPLICATION_JSON)
    WeatherResponse getWeatherOld(@QueryParam("lat") double lat,
                                  @QueryParam("lon") double lon,
                                  @QueryParam("appid") String apiKey,
                                  @QueryParam("exclude") String part,
                                  @QueryParam("units") String units);
}

