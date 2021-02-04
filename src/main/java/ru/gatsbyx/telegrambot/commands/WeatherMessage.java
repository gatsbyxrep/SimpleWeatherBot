package ru.gatsbyx.telegrambot.commands;


import org.telegram.telegrambots.meta.api.objects.Message;

import ru.gatsbyx.telegrambot.weatherApi.OpenWeatherAPI;
import ru.gatsbyx.telegrambot.weatherApi.WeatherInfo;

public class WeatherMessage implements IResponseMessageBuilder {

	@Override
	public String build(Message message) {
		OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();
		WeatherInfo weather = openWeatherAPI.getWeather(message.getLocation());
		/* City name 
		 * Main Info
		 * Description
		 * Temperature
		 * Feels like
		 * Humidity
		 * */
		
		String description = weather.getWeather().getDescription().substring(0, 1).toUpperCase() + 
				weather.getWeather().getDescription().substring(1);
		return String.format( 
				"🏙️ <b>%s in %s now</b>\n" + 
				"🌡️ Temperature: %.0f °C\n" +
				"🌡️ Feels like: %.0f °C\n" +
				"💧 Humidity: %d %%\n", 
				description, weather.getName(),
				weather.getMainInfo().getTemp(), weather.getMainInfo().getFeelsLike(), 
				weather.getMainInfo().getHumidity());
	}

}
