package ru.gatsbyx.telegrambot.commands;

import org.telegram.telegrambots.meta.api.objects.Message;


public class StartMessage implements IResponseMessageBuilder {
	@Override
	public String build(Message message) {
		return "Hello, this is the simple weather bot";
	}
}
