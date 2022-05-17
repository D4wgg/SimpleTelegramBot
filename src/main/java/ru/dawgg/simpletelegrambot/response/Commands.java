package ru.dawgg.simpletelegrambot.response;

import lombok.Getter;

@Getter
public enum Commands {
    HELP("/help"), START("/start"), DOLLAR("/dollar"), WEATHER("/weather");

    private final String stringCommand;

    Commands(String command) {
        this.stringCommand = command;
    }
}
