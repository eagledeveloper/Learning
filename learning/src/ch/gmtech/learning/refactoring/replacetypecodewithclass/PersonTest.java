package ch.gmtech.learning.refactoring.replacetypecodewithclass;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person _person;
	
	@Before
	public void init() {
		_person = new Person(BloodGroup.B);
	}

	@Test
	public void testSetBloodGroup() {
		_person.setBloodGroup(BloodGroup.AB);
		assertEquals(BloodGroup.AB, _person.getBloodGroup());
		assertEquals(BloodGroup.AB.getBloodGroupCode(), _person.getBloodGroup().getBloodGroupCode());
	}

	@Test
	public void testGetBloodGroup() {
		assertEquals(BloodGroup.B, _person.getBloodGroup());
		assertEquals(BloodGroup.B.getBloodGroupCode(), _person.getBloodGroup().getBloodGroupCode());
	}

}
