package ru.dawgg.simpletelegrambot.response;

import org.springframework.stereotype.Component;

@Component
public class Start implements BotResponse {

    private final Commands start = Commands.START;

    @Override
    public String reply() {
        return "App has been started";
    }

    @Override
    public Commands getCommand() {
        return start;
    }
}
