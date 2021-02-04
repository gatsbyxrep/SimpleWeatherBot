package ru.gatsbyx.telegrambot.weatherApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Location;

@Service
public class OpenWeatherAPI  {

	@Value("${weatherAPI.url}")
	private String weatherApiUrl;
	@Value("${weatherAPI.token}")
	private String weatherApiKey;
	@Value("${weatherAPI.version}")
	private String weatherApiVersion;
	
	protected final RestTemplate restTemplate;
	
	
	public OpenWeatherAPI() {
		this.restTemplate = new RestTemplate();
	}

	public WeatherInfo getWeather(Location location) {	
		String url = weatherApiUrl + weatherApiVersion + 
				"/weather?lat={lat}&lon={lon}&units=metric&appid=" + weatherApiKey;
		return this.restTemplate.getForObject(url, WeatherInfo.class, location.getLatitude(), location.getLongitude());
	}

}
