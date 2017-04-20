package com.seminar.util.checker;

import java.util.ArrayList;
import java.util.List;

public class MultiChecker extends Checker {
	
	private List<Checker> _checkers = new ArrayList<>();

	public MultiChecker(String name, String toCheck, List<Checker> checkers) {
		super(name, toCheck);
		_checkers = checkers;
	}
	
	@Override
	public boolean isOk() {
		boolean toReturn = true;
		for(Checker checker : _checkers) {
			toReturn = toReturn && checker.isOk();
		}
		return toReturn;
	}

	@Override
	public List<String> message() {
		for(Checker checker : _checkers) {
			_messages.addAll(checker.message());
		}
		return _messages;
	}

}
