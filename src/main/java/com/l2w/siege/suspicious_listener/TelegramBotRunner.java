package com.l2w.siege.suspicious_listener;

import com.l2w.siege.suspicious_listener.service.TelegramBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
@ConditionalOnProperty(name = "telegram.bot.enabled", havingValue = "true", matchIfMissing = true)
public class TelegramBotRunner implements CommandLineRunner {

    @Autowired
    private TelegramBotService telegramBotService;

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
