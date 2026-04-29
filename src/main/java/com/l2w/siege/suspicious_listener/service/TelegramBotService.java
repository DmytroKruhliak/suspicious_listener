package com.l2w.siege.suspicious_listener.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.logging.Logger;

@Service
public class TelegramBotService extends TelegramLongPollingBot {

    private static final Logger logger = Logger.getLogger(TelegramBotService.class.getName());

    public TelegramBotService(@Value("${telegram.bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "suspicious_listener_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) {
            logger.info("Received an update that is not a text message: " + update.toString());
            return;
        }

        var message = update.getMessage();
        if (message.hasText()) {
            String messageText = message.getText();
            String senderName = message.getFrom().getFirstName();

            logger.info("Received message from " + senderName + ": " + messageText);
        } else {
            logger.info("Received an update that is not a text message: " + update.toString());
        }
    }
}
