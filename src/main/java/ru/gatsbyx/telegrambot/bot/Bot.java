package ru.gatsbyx.telegrambot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {
	// Annotations for reading filing credentials from application.yaml
	@Value("${bot.name}")
	private String username;
	
	@Value("${bot.token}")
	private String token;
	
	// Performing message recieving
	@Override
	public void onUpdateReceived(Update update) {
		try {
			SendMessage sendMessage = new SendMessage();
			sendMessage.setChatId(update.getMessage().getChatId().toString());
			sendMessage.setText("Hi");
            execute(sendMessage);
            System.out.println("Recieved text:" + update.getMessage().getText());
            
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
	
	// Getters
	public String getBotUsername() {
		return username;
	}
	
	public String getBotToken() {
		return token;
	}

}
