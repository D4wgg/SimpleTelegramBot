package ru.dawgg.simpletelegrambot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SimpleTelegramBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleTelegramBotApplication.class, args);
	}
}
