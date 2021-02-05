package ru.gatsbyx.telegrambot.bot;


import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import ru.gatsbyx.telegrambot.config.HibernateConfig;
import ru.gatsbyx.telegrambot.dao.UserDAO;

@SpringBootApplication
@ComponentScan("ru.gatsbyx.telegrambot") // base-package
public class App extends SpringBootServletInitializer {
	
	@Bean
	public UserDAO getUserDAO() {
		return new UserDAO();
	}
	protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class};
    }
	
	public static void main(String[] args) {	
		// Configure later before deploying
		org.apache.log4j.BasicConfigurator.configure();
		SpringApplication.run(App.class, args);
	}

}
