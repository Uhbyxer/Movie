package com.epam.spring.movie.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@SuiteClasses({ UserServiceTest.class, EventServiceTest.class })
public class ServiceSuite {
	
}
