package com.example.demo.service;

import com.example.demo.dto.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    String getCurrentWeather(String city);
}
