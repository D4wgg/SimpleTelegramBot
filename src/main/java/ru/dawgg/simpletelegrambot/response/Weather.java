package ru.dawgg.simpletelegrambot.response;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Weather implements BotResponse {

    private final Commands weather = Commands.WEATHER;
    private final OpenWeatherMapClient weatherMapClient;

    @Override
    public String reply() {
        return weatherMapClient.airPollution().current().toString();
    }

    @Override
    public Commands getCommand() {
        return weather;
    }
}
