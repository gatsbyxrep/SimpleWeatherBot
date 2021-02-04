package ru.gatsbyx.telegrambot.weatherApi;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfo {
	
	@JsonProperty("coord")
	private Coord coord;
	
	@JsonProperty("weather")
	private ArrayList<Weather> weathers;
	
	@JsonProperty("main")
	private Main main;
	
	@JsonProperty("name")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public Main getMainInfo() {
		return main;
	}
	
	public Coord getCoord() {
		return coord;
	}
	
	public Weather getWeather() {
		return weathers.get(0);
	}
	
	public static class Main {
		private final double temp;
		private final double feelsLike;
		private final int humidity;
		
		@JsonCreator
		public Main(@JsonProperty("temp") double temp,
					@JsonProperty("feels_like") double feelsLike,
					@JsonProperty("humidity") int humidity) {	
			this.temp = temp;
			this.feelsLike = feelsLike;
			this.humidity = humidity;
		}
	
		public double getTemp() {
			return temp;
		}

		public double getFeelsLike() {
			return feelsLike;
		}

		public int getHumidity() {
			return humidity;
		}
		
	}
	
	public static class Weather {
		private final String main;
		private final String description;
		
		@JsonCreator
		public Weather(@JsonProperty("main") String main,
						@JsonProperty("description") String description) {
			this.main = main;
			this.description = description;
		}
		
		public String getMain() {
			return main;
		}

		public String getDescription() {
			return description;
		}
	}
	
	
	public static class Coord {
		private final int lon;
		private final int lat;
		
		@JsonCreator
		public Coord(@JsonProperty("lon") int longtitude, 
					 @JsonProperty("lat") int latitude) {
			this.lon = longtitude;
			this.lat = latitude;
		}
		
		public int getLongtitude() {
			return lon;
		}
		
		public int getLatitude() {
			return lat;
		}
		
	}
}
