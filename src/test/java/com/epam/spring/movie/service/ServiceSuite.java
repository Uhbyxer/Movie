package com.epam.spring.movie.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;

import com.epam.spring.movie.AppTest;

@RunWith(Suite.class)
@SuiteClasses({ UserServiceTest.class, AppTest.class })
public class ServiceSuite {
	
}
