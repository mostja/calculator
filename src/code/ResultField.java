package code;
import static org.testng.AssertJUnit.assertEquals;

import com.borland.silktest.jtf.Window;

import com.borland.silktest.jtf.Label;


public class ResultField {
	public Label resultField;
	
	public boolean equals(Object obj) {
		return resultField.equals(obj);
	}
	public Object getValue() {
		return resultField.getValue();
	}
	public ResultField(Window Parent){
		setResultField(Parent);
	}
	public void setResultField(Window Parent){
		resultField = Parent.<Label>find("//Label[4]");
	}
	
	public void assertResultEquals(Object expected){
		assertEquals(getValue(), expected);
	}
	public void assertResultIsZero(){
		assertEquals(getValue(), "0");
	}
	
	public void assertMaxNumberOfDigits(){
		assertEquals(getValue().toString().length(), 16);
	}
	public void assertDivExcept(){
		assertEquals(getValue(), "Cannot divide by zero");
	}

}