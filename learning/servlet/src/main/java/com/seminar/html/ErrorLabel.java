package com.seminar.html;

public class ErrorLabel extends Label {

	public ErrorLabel(String inputId, String labelName, String inputValue, String errorText) {
		super(inputId, labelName);
		_inputValue = inputValue;
		_divClass = "form-group has-error has-feedback";
		_span1Class = "glyphicon glyphicon-remove form-control-feedback";
		_span2Class = "help-block";
		_span2Text = errorText;
	}

}
