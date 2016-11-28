package ch.gmtech.learning.refactoring.introducelocalextension;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

public class TestMyDate {
	
	private Date _lastYear, _thisYear;
	
	@Before
	public void setup() {
		_lastYear = new Date(2015, 1, 1);
		_thisYear = new Date(2016, 1, 1);
	}

	@Test
	public void testSuclass() {
		MyDateSubclass myDateSubclass = new MyDateSubclass(2016, 1, 1);
		assertTrue(myDateSubclass.isSameYear(_thisYear));
		assertFalse(myDateSubclass.isSameYear(_lastYear));
	}
	
	@Test
	public void testWrapper() {
		MyDateWrapper myDateWrapper = new MyDateWrapper(_thisYear);
		assertTrue(myDateWrapper.isSameYear(_thisYear));
		assertFalse(myDateWrapper.isSameYear(_lastYear));
		
	}

}
