package com.weather.soapservice.endpoint;

import com.weather.soapservice.service.WeatherService;
import com.weather.soapservice.xjc.Weather;
import com.weather.soapservice.xjc.WeatherRequest;
import com.weather.soapservice.xjc.WeatherResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WeatherServiceEndpoint {

    private WeatherService weatherService;

    public WeatherServiceEndpoint(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    private static final String NAMESPACE_URI = "http://www.weather.com/soapservice/xjc";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "WeatherRequest")
    @ResponsePayload
    public WeatherResponse getWeatherData(@RequestPayload WeatherRequest request) {
        Weather weather = weatherService.getWeatherEntity(request);
        WeatherResponse response = new WeatherResponse();
        response.setWeather(weather);
        return response;

    }
}
