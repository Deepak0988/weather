package com.weather.soapservice.repo;

import com.weather.soapservice.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface WeatherRepo extends JpaRepository<WeatherEntity, Integer> {
    WeatherEntity findByZipAndDate(int zip, LocalDate date);
}