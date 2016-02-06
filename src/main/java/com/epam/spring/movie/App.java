package com.epam.spring.movie;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {
	private String hello;
	
	public App(String hello) {
		this.hello = hello;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		App app = (App) ctx.getBean("app");
		
		System.out.println(app.hello);
	}
}
