package com.seminar.html;

import java.util.List;

public class SuccesLabel extends Label {
	
	public SuccesLabel(String inputId, String labelName, String inputValue, List<String> successText) {
		super(inputId, labelName);
		_inputValue = inputValue;
		_divClass = "form-group has-success has-feedback";
		_span1Class = "glyphicon glyphicon-ok form-control-feedback";
		_span2Class = "help-block";
		_span2Texts = successText;
	}

}
