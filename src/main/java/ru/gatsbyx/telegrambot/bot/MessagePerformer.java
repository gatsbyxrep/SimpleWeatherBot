package ru.gatsbyx.telegrambot.bot;

import java.util.HashMap;
import java.util.function.Function;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import ru.gatsbyx.telegrambot.commands.IResponseMessageBuilder;
import ru.gatsbyx.telegrambot.commands.StartMessage;
import ru.gatsbyx.telegrambot.commands.WeatherMessage;

@Component
public class MessagePerformer {
	
	private HashMap<String, IResponseMessageBuilder> commandResponseMap = new HashMap<>();
	
	public MessagePerformer() {
		commandResponseMap.put("/start", new StartMessage());
		
	}
		
	public SendMessage perform(Message message) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.enableMarkdown(true);
		sendMessage.enableHtml(true);
		
		String messageText = "Unknown command, use /help";
		IResponseMessageBuilder msgBuilder = null;
		
		if(message.hasLocation())
			msgBuilder = new WeatherMessage();
		else {
			String command = message.getText().split(" ")[0];
			msgBuilder = commandResponseMap.get(command);
		}
		if(msgBuilder != null)
			messageText  = msgBuilder.build(message);
		
		sendMessage.setText(messageText);
		return sendMessage;
	}
	
	
	

}
