package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.net.URISyntaxException;

@Repository
public interface WeatherRepository {
    String getWeatherPerCity(String city);
}
