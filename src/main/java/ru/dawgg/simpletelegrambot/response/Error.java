package ru.dawgg.simpletelegrambot.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Getter
public class Error {

    private final List<BotResponse> responses;

    public String reply() {
        List<String> commands = responses.stream()
                .map(botResponse -> botResponse.getCommand().getStringCommand()).toList();
        return "Такой команды нема, попробуй следущие: \n" + String.join("\n", commands);
    }
}
