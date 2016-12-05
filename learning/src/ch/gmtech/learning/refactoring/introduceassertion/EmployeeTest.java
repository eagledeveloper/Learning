package ch.gmtech.learning.refactoring.introduceassertion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void withProject() {
		Employee employee = new Employee(new Project());
		assertFalse("false expected", employee.withinLimit(50.0));
		assertTrue("true expected", employee.withinLimit(-5.0));
	}
	
	@Test
	public void withoutProject() {
		Employee employee = new Employee(5.0);
		assertFalse("false expected", employee.withinLimit(50.0));
		assertTrue("true expected", employee.withinLimit(-5.0));
	}

}
