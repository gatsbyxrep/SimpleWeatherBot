package ru.gatsbyx.telegrambot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface IResponseMessageBuilder {
	
	String build(Message message);

}
