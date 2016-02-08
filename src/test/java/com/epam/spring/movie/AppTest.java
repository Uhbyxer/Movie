package com.epam.spring.movie;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class AppTest extends AbstractTestCase{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	//@Ignore
	@Test
	public void test() {
		System.out.println("App test....");
	}

}
