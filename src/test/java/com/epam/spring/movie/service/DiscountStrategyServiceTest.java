package com.epam.spring.movie.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.epam.spring.movie.AbstractTestCase;
import com.epam.spring.movie.bean.DiscountStrategy;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DiscountStrategyServiceTest extends AbstractTestCase {

	public static int testCounter = 0;
	
	@Autowired
	private DiscountStrategyService discountService;
	
	public void setDiscountService(DiscountStrategyService discountService) {
		this.discountService = discountService;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("\n*********************************************** Discount strategy Tests --->");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\nTest # " + ++testCounter);
	}

	@Test
	public void testGetAll() {
		System.out.println("Get all strategies :");
		List<DiscountStrategy> list = discountService.getAll();
		list.forEach(System.out::println);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetListByName() {
		DiscountStrategy discount = discountService.getAll().get(0);
		System.out.println("Get discount by name: " + discount.getName());
		DiscountStrategy found = discountService.getListByName(discount.getName()).get(0);
		assertEquals(discount.getName(), found.getName());
	}

	@Test
	public void testGetBestDiscountStrategy() {
		//discountService.getBestDiscountStrategy(ticket, countOfTicketsForUser)
		fail("not yet");
	}

}
