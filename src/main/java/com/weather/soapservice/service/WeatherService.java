package com.weather.soapservice.service;

import com.weather.soapservice.entity.WeatherEntity;
import com.weather.soapservice.exception.WeatherException;
import com.weather.soapservice.repo.WeatherRepo;
import com.weather.soapservice.xjc.Weather;
import com.weather.soapservice.xjc.WeatherRequest;
import com.weather.soapservice.xjc.WeatherResponse;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

@Service
public class WeatherService {

    private WeatherRepo weatherRepo;

    public WeatherService(WeatherRepo weatherRepo){
        this.weatherRepo = weatherRepo;
    }

    public Weather getWeatherEntity(WeatherRequest request) throws WeatherException {
        try {
            XMLGregorianCalendar weatherDate = request.getDate();
            LocalDate date = LocalDate.of(
                    weatherDate.getYear(),
                    weatherDate.getMonth(),
                    weatherDate.getDay());
            WeatherEntity entity = weatherRepo.findByZipAndDate(request.getZip(), date);
            Weather weather = new Weather();
            weather.setMin(String.valueOf(entity.getMin()));
            weather.setMax(String.valueOf(entity.getMax()));
            return weather;
        } catch (Exception e) {
            throw new WeatherException("No Data Found");
        }

    }
}
