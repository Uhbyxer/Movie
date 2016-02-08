package com.epam.spring.movie.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.spring.movie.AbstractTestCase;
import com.epam.spring.movie.bean.Assignment;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssignmentServiceTest extends AbstractTestCase {
	public static int testCounter = 0;
	
	@Autowired
	private AssignmentService assignmentService;
	
	
	@Autowired
	@Qualifier("new_assign_4")
	private Assignment newAssignment;

	
	public void setAssignmentService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}
	
	public void setNewAssignment(Assignment newAssignment) {
		this.newAssignment = newAssignment;
	}

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("\n*********************************************** AssignmentService Tests --->");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\nTest # " + ++testCounter);
	}

	@Test
	public void testIsAssigned() {
		System.out.println("Is assigned: " + newAssignment);
		assertTrue(assignmentService.isAssigned(newAssignment.getAuditorium(), newAssignment.getDateTime()));
	}

	@Test
	public void testCreate() {
		System.out.println("Assign auditorium for event: ");
		System.out.println(newAssignment);
		assignmentService.create(newAssignment);
		Assignment assignment = assignmentService.getById(newAssignment.getId());
		assertNotNull(assignment);	}

	@Test
	public void testRemove() {
		System.out.println("Removing " + newAssignment);
		assignmentService.remove(newAssignment);
		Assignment assignment = assignmentService.getById(newAssignment.getId());
		assertNull(assignment);
	}

	@Test
	public void testGetAll() {
		List<Assignment> assignments = assignmentService.getAll();
		System.out.println("Get all assigments:");
		assignments.forEach(System.out::println);
		assertTrue(assignments.size() > 0);
	}

	@Test
	public void testGetById() {
		System.out.println("Get by id = " + newAssignment.getId());
		Assignment assignment = assignmentService.getById(newAssignment.getId());
		assertNotNull(assignment);
	}

}
