package com.epam.spring.movie.aspect;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.epam.spring.movie.service.ServiceSuite;


@RunWith(Suite.class)
@SuiteClasses({ ServiceSuite.class, CounterAspectTest.class})
public class ServiceAndAspectSuite {
	
}
