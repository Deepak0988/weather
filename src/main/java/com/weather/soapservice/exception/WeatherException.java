package com.weather.soapservice.exception;


public class WeatherException extends RuntimeException {
    public WeatherException(String message){
        super(message);
    }
}
