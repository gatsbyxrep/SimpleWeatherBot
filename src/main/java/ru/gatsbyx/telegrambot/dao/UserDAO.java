package ru.gatsbyx.telegrambot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ru.gatsbyx.telegrambot.models.User;

@Repository
@Transactional
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void add(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(user);
	}
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);
	}
	public User getById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Optional<User> getByChatId(Long chatId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where chat_id = :chatId", User.class);
		query.setParameter("chatId", chatId);
		return query.getResultStream().findFirst();
	}
}
