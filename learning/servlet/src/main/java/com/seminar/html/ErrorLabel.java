package com.seminar.html;

import java.util.List;

public class ErrorLabel extends Label {

	public ErrorLabel(String inputId, String labelName, String inputValue, List<String> errorText) {
		super(inputId, labelName);
		_inputValue = inputValue;
		_divClass = "form-group has-error has-feedback";
		_span1Class = "glyphicon glyphicon-remove form-control-feedback";
		_span2Class = "help-block";
		_span2Texts = errorText;
	}

}
