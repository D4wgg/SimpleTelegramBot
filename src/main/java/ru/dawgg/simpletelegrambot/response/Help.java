package ru.dawgg.simpletelegrambot.response;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Help implements BotResponse {

    private final Commands help = Commands.HELP;

    @Override
    public String reply() {
        return "User needs some help";
    }

    @Override
    public Commands getCommand() {
        return help;
    }
}
