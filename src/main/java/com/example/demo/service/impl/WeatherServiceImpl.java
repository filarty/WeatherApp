package com.example.demo.service.impl;


import com.example.demo.dto.Weather;
import com.example.demo.repository.WeatherRepository;
import com.example.demo.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final WeatherRepository weatherRepository;

    @Override
    public String getCurrentWeather(String city) {
        return weatherRepository.getWeatherPerCity(city);
    }
}
