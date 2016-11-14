package ch.gmtech.learning.refactoring.replacedelegationwithinheritance;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	
	private Employee employee;
	private static final String employeeFullName = "Valentino Decarli";
	
	@Before
	public void setup() {
		employee = new Employee();
		employee.setFullName(employeeFullName);
	}

	@Test
	public void testGetName() {
		assertEquals(employeeFullName, employee.getFullName());
	}

	@Test
	public void testGetLetterHead() {
		assertEquals("Emp: Decarli", employee.getLetterHead());
	}

}
