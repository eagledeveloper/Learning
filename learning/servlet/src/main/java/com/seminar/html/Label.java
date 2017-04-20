package com.seminar.html;

import java.util.ArrayList;
import java.util.List;

public class Label {
	
	// div --> class
	// input --> id
	// input + label --> name
	// input --> value
	// input --> placeholder? --> when empty == labelName
	// span1 --> class
	// span2 --> text, class
	
	protected String _divClass = "form-group", _inputId;
//	private String _inputName;
	protected String _labelName, _inputValue;
//	private String _inputPlaceholder; 
	protected String _span1Class, _span2Class;
	protected List<String> _span2Texts = new ArrayList<String>();
	
	public Label(String inputId, String labelName) {
		_inputId = inputId;
		_labelName = labelName;
	}
	
	public String divClass() {
		return preventNull(_divClass);
	}
	
	public String inputId() {
		return preventNull(_inputId);
	}
	
	public String inputName() {
		// TODO
		return preventNull(_inputId);
//		return preventNull(_inputName);
	}
	
	public String labelName() {
		return preventNull(_labelName);
	}
	
	public String inputValue() {
		return preventNull(_inputValue);
	}
	
	public String inputPlaceholder() {
		// TODO
		return preventNull(_labelName);
//		return preventNull(_inputPlaceholder);
	}
	
	public String span1Class() {
		return preventNull(_span1Class);
	}
	
	public List<String> span2Text() {
		return preventNull(_span2Texts);
	}

	public String span2Class() {
		return preventNull(_span2Class);
	}
	
	private List<String> preventNull(List<String> stringList) {
		List<String> result = new ArrayList<>();
		
		for(String string : stringList) {
			result.add(preventNull(string));
		}
		
		return result;
	}
	
	private String preventNull(String s) {
		return s != null ? s : "";
	}

}
