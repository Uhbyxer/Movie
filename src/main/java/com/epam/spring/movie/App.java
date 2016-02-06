package com.epam.spring.movie;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.movie.bean.User;
import com.epam.spring.movie.dao.UserDao;



public class App {
	public static final ConfigurableApplicationContext CTX = new ClassPathXmlApplicationContext("spring.xml");
	

	public static void main(String[] args) {
		App app = (App) CTX.getBean("app");
		
		
		
		System.out.println("=============================== User service ===============================");
		
		UserDao userDao = (UserDao) CTX.getBean("userDaoStub");
		System.out.println("User by id = 1 : " + userDao.getById(1));
	
		User user = userDao.getUserByEmail("bruce_willis@gmail.com");
		System.out.println("User by email (bruce_willis@gmail.com)   : " + user);
		
		System.out.println("\nBy name = john doe :");
		userDao.getUsersByName("john doe").forEach(System.out::println);
		
		System.out.println("\nAll :");
		userDao.getAll().forEach(System.out::println);
		
		System.out.println("\nRemove Bruce:");
		userDao.remove(user);
		userDao.getAll().forEach(System.out::println);
		
		System.out.println("\nAdd Bruce:");
		userDao.create(user);
		userDao.getAll().forEach(System.out::println);
		
	}
}
