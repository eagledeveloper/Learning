package ch.gmtech.learning.refactoring.hidedelegate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		
		Person valentino = new Person();
		Department department = new Department(valentino);
		
		valentino.setDepartment(department);
		
		assertEquals(valentino.getManager(), valentino);
	}

}
