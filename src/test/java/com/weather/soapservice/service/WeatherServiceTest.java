package com.weather.soapservice.service;

import com.weather.soapservice.entity.WeatherEntity;
import com.weather.soapservice.exception.WeatherException;
import com.weather.soapservice.repo.WeatherRepo;
import com.weather.soapservice.xjc.Weather;
import com.weather.soapservice.xjc.WeatherRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.xml.datatype.DatatypeFactory;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class WeatherServiceTest {

    @Mock
    WeatherRepo repo;

    @InjectMocks
    WeatherService service;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeatherEntityHappyPath() throws Exception {
        WeatherRequest request = new WeatherRequest();
        request.setZip(1);
        request.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setMin(10);
        weatherEntity.setMax(11);
        Mockito.doReturn(weatherEntity).when(repo).findByZipAndDate(ArgumentMatchers.anyInt(), ArgumentMatchers.any(LocalDate.class));
        Weather response = service.getWeatherEntity(request);
        Assertions.assertTrue(response != null);
    }

    @Test
    public void testGetWeatherEntityUnHappyPath() throws Exception {
        WeatherRequest request = new WeatherRequest();
        request.setZip(1);
        request.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setMin(10);
        weatherEntity.setMax(11);
        Mockito.doThrow(new WeatherException("test")).when(repo).findByZipAndDate(ArgumentMatchers.anyInt(), ArgumentMatchers.any(LocalDate.class));
    }
}
