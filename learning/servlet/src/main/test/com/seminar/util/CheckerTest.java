package com.seminar.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.seminar.util.checker.AlwaysValidChecker;
import com.seminar.util.checker.Checker;
import com.seminar.util.checker.DateChecker;
import com.seminar.util.checker.MaxLengthChecker;
import com.seminar.util.checker.MaxNumericChecker;
import com.seminar.util.checker.MinNumericChecker;
import com.seminar.util.checker.MultiChecker;
import com.seminar.util.checker.NotEmptyChecker;
import com.seminar.util.checker.NumericChecker;

public class CheckerTest {
	
	private Checker _checker;

	@Test
	public void testDateChecker() {
		_checker = new DateChecker("DateChecker", "01.01.2015");
		assertTrue(_checker.isOk());
		assertEquals("DateChecker has a valid format", _checker.message().get(0));
		_checker = new DateChecker("DateChecker", "");
		assertFalse(_checker.isOk());
		assertEquals("DateChecker hasn't a valid format, it should be dd.mm.yyyy", _checker.message().get(0));
		_checker = new DateChecker("DateChecker", null);
		assertFalse(_checker.isOk());
		assertEquals("DateChecker hasn't a valid format, it should be dd.mm.yyyy", _checker.message().get(0));
	}

	@Test
	public void testMaxLengthChecker() {
		_checker = new MaxLengthChecker("MaxLengthChecker", "0123456789", 10);
		assertTrue(_checker.isOk());
		assertEquals("MaxLengthChecker length is ok", _checker.message().get(0));
		_checker = new MaxLengthChecker("MaxLengthChecker", "01234567890", 10);
		assertFalse(_checker.isOk());
		assertEquals("MaxLengthChecker is to long", _checker.message().get(0));
		_checker = new MaxLengthChecker("MaxLengthChecker", "", 10);
		assertTrue(_checker.isOk());
		assertEquals("MaxLengthChecker length is ok", _checker.message().get(0));
		_checker = new MaxLengthChecker("MaxLengthChecker", null, 10);
		assertTrue(_checker.isOk());
		assertEquals("MaxLengthChecker length is ok", _checker.message().get(0));
	}
	
	@Test
	public void testMaxNumericChecker() {
		_checker = new MaxNumericChecker("MaxNumericChecker", "99", 100);
		assertTrue(_checker.isOk());
		assertEquals("MaxNumericChecker is valid", _checker.message().get(0));
		_checker = new MaxNumericChecker("MaxNumericChecker", "100", 100);
		assertFalse(_checker.isOk());
		assertEquals("MaxNumericChecker is too high, it should be less than 100", _checker.message().get(0));
		_checker = new MaxNumericChecker("MaxNumericChecker", "abc", 100);
		assertFalse(_checker.isOk());
		assertEquals("MaxNumericChecker isn't a number", _checker.message().get(0));
		_checker = new MaxNumericChecker("MaxNumericChecker", null, 100);
		assertFalse(_checker.isOk());
		assertEquals("MaxNumericChecker isn't a number", _checker.message().get(0));
	}
	
	@Test
	public void testMinNumericChecker() {
		_checker = new MinNumericChecker("MinNumericChecker", "99", 0);
		assertTrue(_checker.isOk());
		assertEquals("MinNumericChecker is valid", _checker.message().get(0));
		_checker = new MinNumericChecker("MinNumericChecker", "100", 100);
		assertFalse(_checker.isOk());
		assertEquals("MinNumericChecker is too low, it should be greater than 100", _checker.message().get(0));
		_checker = new MinNumericChecker("MinNumericChecker", "abc", 100);
		assertFalse(_checker.isOk());
		assertEquals("MinNumericChecker isn't a number", _checker.message().get(0));
		_checker = new MinNumericChecker("MinNumericChecker", null, 100);
		assertFalse(_checker.isOk());
		assertEquals("MinNumericChecker isn't a number", _checker.message().get(0));
	}
	
	@Test
	public void testNotEmptyChecker() {
		_checker = new NotEmptyChecker("NotEmptyChecker", "Not empty string");
		assertTrue(_checker.isOk());
		assertEquals("NotEmptyChecker is valid", _checker.message().get(0));
		_checker = new NotEmptyChecker("NotEmptyChecker", "");
		assertFalse(_checker.isOk());
		assertEquals("NotEmptyChecker cannot be empty", _checker.message().get(0));
		_checker = new NotEmptyChecker("NotEmptyChecker", null);
		assertFalse(_checker.isOk());
		assertEquals("NotEmptyChecker cannot be empty", _checker.message().get(0));
	}
	
	@Test
	public void testNumericChecker() {
		_checker = new NumericChecker("NumericChecker", "99");
		assertTrue(_checker.isOk());
		assertEquals("NumericChecker is a valid number", _checker.message().get(0));
		_checker = new NumericChecker("NumericChecker", "abc");
		assertFalse(_checker.isOk());
		assertEquals("NumericChecker isn't a number", _checker.message().get(0));
		_checker = new NumericChecker("NumericChecker", null);
		assertFalse(_checker.isOk());
		assertEquals("NumericChecker isn't a number", _checker.message().get(0));
	}
	
	@Test
	public void testMultiChecker() {
		_checker = new MultiChecker("MultiChecker", "fakeToCheck", new ArrayList<>());
		assertTrue(_checker.isOk());
		assertTrue(_checker.message().isEmpty());
		
		List<Checker> checkers = new ArrayList<>();
		checkers.add(new NumericChecker("NumericChecker", "99"));
		_checker = new MultiChecker("MultiChecker", "fakeToCheck", checkers);
		assertTrue(_checker.isOk());
		assertEquals("NumericChecker is a valid number", _checker.message().get(0));
		
		checkers = new ArrayList<>();
		checkers.add(new NumericChecker("NumericChecker1", "99"));
		checkers.add(new NumericChecker("NumericChecker2", "abc"));
		_checker = new MultiChecker("MultiChecker", "fakeToCheck", checkers);
		assertFalse(_checker.isOk());
		assertEquals("NumericChecker1 is a valid number", _checker.message().get(0));
		assertEquals("NumericChecker2 isn't a number", _checker.message().get(1));
	}
	
	@Test
	public void testAlwayValidChecker() {
		_checker = new AlwaysValidChecker("AlwaysValidChecker", null);
		assertTrue(_checker.isOk());
		assertEquals("AlwaysValidChecker is valid!", _checker.message().get(0));
		_checker = new AlwaysValidChecker("AlwaysValidChecker", "");
		assertTrue(_checker.isOk());
		assertEquals("AlwaysValidChecker is valid!", _checker.message().get(0));
		_checker = new AlwaysValidChecker("AlwaysValidChecker", "abc");
		assertTrue(_checker.isOk());
		assertEquals("AlwaysValidChecker is valid!", _checker.message().get(0));
		
		
		
		
		
	}

}
