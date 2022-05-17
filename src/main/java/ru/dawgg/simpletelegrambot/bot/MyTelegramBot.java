package ru.dawgg.simpletelegrambot.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.dawgg.simpletelegrambot.config.BotData;
import ru.dawgg.simpletelegrambot.response.BotResponse;
import ru.dawgg.simpletelegrambot.response.Error;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MyTelegramBot extends TelegramLongPollingBot {

    private final BotData botData;
    private final List<BotResponse> responses;
    private final Error error;

    private Map<String, BotResponse> commandsBotResponseMap;

    @PostConstruct
    public void init() {
        commandsBotResponseMap = responses.stream()
                .collect(Collectors.toMap(botResponse -> botResponse.getCommand().getStringCommand(),
                        botResponse -> botResponse));
    }

    @Override
    public String getBotUsername() {
        return botData.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botData.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = getSendMessage(update);

        BotResponse botResponse = commandsBotResponseMap.get(update.getMessage().getText());

        if (botResponse != null) {
            executeMessage(sendMessage, botResponse.reply());
        } else {
            executeMessage(sendMessage, error.reply());
        }
    }

    private SendMessage getSendMessage(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setReplyToMessageId(update.getMessage().getMessageId());

        return sendMessage;
    }

    public void executeMessage(SendMessage sendMessage, String message) {
        sendMessage.setText(message);
        try {
            sendApiMethod(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
