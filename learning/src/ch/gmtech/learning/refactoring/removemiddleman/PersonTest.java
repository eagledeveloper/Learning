package ch.gmtech.learning.refactoring.removemiddleman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		
		Person valentino = new Person();
		Department department = new Department(valentino);
		
		valentino.setDepartment(department);
		
		assertEquals(valentino.getDepartment(), department);
		assertEquals(valentino.getDepartment().getManager(), valentino);
	}

}
