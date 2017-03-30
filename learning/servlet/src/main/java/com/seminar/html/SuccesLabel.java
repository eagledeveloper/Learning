package com.seminar.html;

public class SuccesLabel extends Label {
	
	public SuccesLabel(String inputId, String labelName, String inputValue, String successText) {
		super(inputId, labelName);
		_inputValue = inputValue;
		_divClass = "form-group has-success has-feedback";
		_span1Class = "glyphicon glyphicon-ok form-control-feedback";
		_span2Class = "help-block";
		_span2Text = successText;
	}

}
