package com.example.demo.controller;


import com.example.demo.dto.Weather;
import com.example.demo.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/weather")
public class TestController {
    private final WeatherService weatherService;

    @GetMapping()
    public ResponseEntity<Weather> getWeather(@RequestParam String city) {

        Weather weather = new Weather(city, weatherService.getCurrentWeather(city));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(weather);
    }
}
