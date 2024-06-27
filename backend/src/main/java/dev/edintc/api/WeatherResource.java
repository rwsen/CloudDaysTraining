package dev.edintc.api;

import dev.edintc.domain.WeatherResponse;
import dev.edintc.service.WeatherCachingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/weather")
public class WeatherResource {

    private static final Logger LOG = Logger.getLogger(WeatherResource.class);

    @ConfigProperty(name = "weather.api.apiKey")
    String apiKey;

    @Inject
    WeatherCachingService weatherCachingService;

    @GET
    @Path("/current")
    @Produces(MediaType.APPLICATION_JSON)
    public WeatherResponse getWeather(@QueryParam("city") String city) {
        long executionStart = System.currentTimeMillis();

        LOG.infof("Calling weather service for city: " + city);

        WeatherResponse weatherResponse = weatherCachingService.getWeather(city, apiKey, "metric");

        long executionEnd = System.currentTimeMillis();

        LOG.infof("Execution time: " + (executionEnd - executionStart) + "ms");

        return weatherResponse;
    }
}
