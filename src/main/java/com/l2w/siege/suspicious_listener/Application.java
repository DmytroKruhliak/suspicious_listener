package com.l2w.siege.suspicious_listener;

import com.l2w.siege.suspicious_listener.service.TelegramBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private TelegramBotService telegramBotService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
			api.registerBot(telegramBotService);
			System.out.println("Bot registered successfully!");
		} catch (TelegramApiException e) {
			System.err.println("Failed to register bot: " + e.getMessage());
			throw e;
		}
	}

}
