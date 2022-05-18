package ru.dawgg.simpletelegrambot.response;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.github.prominence.openweathermap.api.enums.Language;
import com.github.prominence.openweathermap.api.enums.UnitSystem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Weather implements BotResponse {

    private final Commands weather = Commands.WEATHER;
    private final OpenWeatherMapClient weatherMapClient;

    @Override
    public String reply() {
        com.github.prominence.openweathermap.api.model.weather.Weather weather = weatherMapClient
                .currentWeather()
                .single()
                .byCityName("Moscow")
                .language(Language.RUSSIAN)
                .unitSystem(UnitSystem.METRIC)
                .retrieve()
                .asJava();
        return weather.getTemperature() + "\n" + weather.getHumidity();
    }

    @Override
    public Commands getCommand() {
        return weather;
    }
}
