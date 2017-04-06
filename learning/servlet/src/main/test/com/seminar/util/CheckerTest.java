package com.seminar.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.seminar.util.checker.Checker;
import com.seminar.util.checker.DateChecker;
import com.seminar.util.checker.MaxLengthChecker;
import com.seminar.util.checker.MaxNumericChecker;
import com.seminar.util.checker.NotEmptyChecker;
import com.seminar.util.checker.NumericChecker;

public class CheckerTest {
	
	private Checker _checker;

	@Test
	public void testDateChecker() {
		_checker = new DateChecker("DateChecker", "01.01.2015");
		assertTrue(_checker.isOk());
		assertEquals("DateChecker has a valid format", _checker.message());
		_checker = new DateChecker("DateChecker", "");
		assertFalse(_checker.isOk());
		assertEquals("DateChecker hasn't a valid format, it should be dd.mm.yyyy", _checker.message());
		_checker = new DateChecker("DateChecker", null);
		assertFalse(_checker.isOk());
		assertEquals("DateChecker hasn't a valid format, it should be dd.mm.yyyy", _checker.message());
	}

	@Test
	public void testMaxLengthChecker() {
		_checker = new MaxLengthChecker("MaxLengthChecker", "0123456789", 10);
		assertTrue(_checker.isOk());
		assertEquals("MaxLengthChecker length is ok", _checker.message());
		_checker = new MaxLengthChecker("MaxLengthChecker", "01234567890", 10);
		assertFalse(_checker.isOk());
		assertEquals("MaxLengthChecker is to long", _checker.message());
		_checker = new MaxLengthChecker("MaxLengthChecker", "", 10);
		assertTrue(_checker.isOk());
		assertEquals("MaxLengthChecker length is ok", _checker.message());
		_checker = new MaxLengthChecker("MaxLengthChecker", null, 10);
		assertTrue(_checker.isOk());
		assertEquals("MaxLengthChecker length is ok", _checker.message());
	}
	
	//return super.message() + (isOk() ? "" : "\n" + _name + " is to high, it should be less than " + _maxNumber);
	//MaxNumericChecker
	@Test
	public void testMaxNumericChecker() {
		_checker = new MaxNumericChecker("MaxNumericChecker", "99", 100);
		assertTrue(_checker.isOk());
		assertEquals("MaxNumericChecker is a valid number", _checker.message());
		_checker = new MaxNumericChecker("MaxNumericChecker", "100", 100);
		assertFalse(_checker.isOk());
		assertEquals("MaxNumericChecker is a valid number\nMaxNumericChecker is to high, it should be less than 100", _checker.message());
		_checker = new MaxNumericChecker("MaxNumericChecker", "abc", 100);
		assertFalse(_checker.isOk());
		assertEquals("MaxNumericChecker isn't a number", _checker.message());
	}
	
	@Test
	public void testNotEmptyChecker() {
		_checker = new NotEmptyChecker("NotEmptyChecker", "Not empty string");
		assertTrue(_checker.isOk());
		assertEquals("NotEmptyChecker is valid", _checker.message());
		_checker = new NotEmptyChecker("NotEmptyChecker", "");
		assertFalse(_checker.isOk());
		assertEquals("NotEmptyChecker cannot be empty", _checker.message());
		_checker = new NotEmptyChecker("NotEmptyChecker", null);
		assertFalse(_checker.isOk());
		assertEquals("NotEmptyChecker cannot be empty", _checker.message());
	}
	
	@Test
	public void testNumericChecker() {
		_checker = new NumericChecker("NumericChecker", "99");
		assertTrue(_checker.isOk());
		assertEquals("NumericChecker is a valid number", _checker.message());
		_checker = new NumericChecker("NumericChecker", "abc");
		assertFalse(_checker.isOk());
		assertEquals("NumericChecker isn't a number", _checker.message());
	}

}
