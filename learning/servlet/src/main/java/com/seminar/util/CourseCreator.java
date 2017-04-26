package com.seminar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.seminar.util.checker.AlwaysValidChecker;
import com.seminar.util.checker.Checker;
import com.seminar.util.checker.DateChecker;
import com.seminar.util.checker.MaxLengthChecker;
import com.seminar.util.checker.MaxNumericChecker;
import com.seminar.util.checker.MinNumericChecker;
import com.seminar.util.checker.MultiChecker;
import com.seminar.util.checker.NotEmptyChecker;

public class CourseCreator {
	
	private List<Checker> _checkers = new ArrayList<>();
	private Checker _nameChecker, _idChecker, _locationChecker, _startDateChecker, _totalSeatsChecker, _descriptionChecker;
	
	public CourseCreator(String name, String startDate, String location, String totalSeats, String id, String description) {
		_nameChecker = createNotEmptyChecker(Course.NAME, name);
		_startDateChecker = new DateChecker(Course.START_DATE, startDate);
		_locationChecker = createNotEmptyChecker(Course.LOCATION, location);
		
		Checker maxNumericChecker = new MaxNumericChecker(Course.TOTAL_SEATS, totalSeats, 100);
		Checker maxLengthChecker = new MaxLengthChecker(Course.TOTAL_SEATS, totalSeats, 3);
		_totalSeatsChecker = new MultiChecker(Course.TOTAL_SEATS, totalSeats, Arrays.asList(maxNumericChecker, maxLengthChecker));
		
		_idChecker = new MinNumericChecker(Course.ID, id, 0);
		_descriptionChecker = new AlwaysValidChecker(Course.DESCRIPTION, description);
		
		_checkers.add(_nameChecker);
		_checkers.add(_startDateChecker);
		_checkers.add(_locationChecker);
		_checkers.add(_totalSeatsChecker);
		_checkers.add(_idChecker);
		_checkers.add(_descriptionChecker);
	}
	
	private Checker createNotEmptyChecker(String name, String toCheck) {
		return new NotEmptyChecker(name, toCheck);
	}
	
	public Course create() {
		for(Checker checker : _checkers) {
			if(!checker.isOk()) return notValidCourse();
		}
		return validCourse();
	}
	
	private Course validCourse() {
		return new ValidCourse(_nameChecker.value(), _idChecker.value(), _descriptionChecker.value(), _startDateChecker.value(), _locationChecker.value(), _totalSeatsChecker.value());
	}

	private Course notValidCourse() {
		return new NotValidCourse(_idChecker, _nameChecker, _descriptionChecker, _startDateChecker, _locationChecker, _totalSeatsChecker);
	}
	
	

}
