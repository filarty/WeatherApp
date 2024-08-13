package com.example.demo.repository.Impl;


import com.example.demo.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;


@Repository
@RequiredArgsConstructor
public class WeatherRepositoryImpl implements WeatherRepository {
    private final RestClient restClient = RestClient.create();

    private String makeUrlRequest(String uri) {
        return restClient.get()
                .uri("https://wttr.in/hamburg?T0")
                .retrieve()
                .body(String.class);
    }


    private String parseWeatherString(String weatherString) {
        String parseStart = weatherString.substring(weatherString.indexOf("\nWeather report"))
                .replace("Weather report: hamburg", "")
                .replace("      ", "")
                .replace("\n", "");
        return parseStart.substring(parseStart.indexOf(".-.") + 3, parseStart.indexOf("°C") + 2);
    }


    @Override
    public String getWeatherPerCity(String city) {
        String uri = "https://wttr.in/hamburg?T0";
        return parseWeatherString(makeUrlRequest(uri));
    }
}

