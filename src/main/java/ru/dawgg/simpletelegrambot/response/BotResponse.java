package ru.dawgg.simpletelegrambot.response;

public interface BotResponse {

    String reply();

    Commands getCommand();
}
