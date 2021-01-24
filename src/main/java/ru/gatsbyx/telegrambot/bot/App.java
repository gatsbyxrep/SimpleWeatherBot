package ru.gatsbyx.telegrambot.bot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main(String[] args) {	
		org.apache.log4j.BasicConfigurator.configure();
		SpringApplication.run(App.class, args);
	}

}
