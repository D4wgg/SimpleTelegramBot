package ru.dawgg.simpletelegrambot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.dawgg.simpletelegrambot.bot.MyTelegramBot;

@Configuration
@RequiredArgsConstructor
public class BotConfig {

    private final MyTelegramBot myTelegramBot;

    @Bean
    public TelegramBotsApi telegramBotsApi() throws TelegramApiException {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(myTelegramBot);
        return telegramBotsApi;
    }
}
