package dev.edintc.service;

import dev.edintc.api.WeatherResource;
import dev.edintc.domain.WeatherResponse;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@ApplicationScoped
public class WeatherCachingService {

    private static final Logger LOG = Logger.getLogger(WeatherResource.class);

    @RestClient
    WeatherService weatherService;

    @CacheResult(cacheName = "weather-cache")
    public WeatherResponse getWeather(String city, String apiKey, String units) {

        LOG.infof("Cache miss for city: " + city);

        return weatherService.getWeather(city, apiKey, units);
    }
}
