package code;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.Window;

public class CalculatorWindow {
	private Desktop desktop = new Desktop();
	public Window window;
	public CalcPushButton button1;
	public CalcPushButton button2;
	public CalcPushButton button3;
	public CalcPushButton button4;
	public CalcPushButton button5;
	public CalcPushButton button6;
	public CalcPushButton button7;
	public CalcPushButton button8;
	public CalcPushButton button9;
	public CalcPushButton button0;
	public CalcPushButton buttonPlus;
	public CalcPushButton buttonMinus;
	public CalcPushButton buttonMultiply;
	public CalcPushButton buttonDivide;
	public CalcPushButton buttonResult;
	public CalcPushButton buttonClear;
	public CalcPushButton buttonClearEntry;
	public CalcPushButton buttonDot;
	public ResultField resultField;
	
	
	public CalculatorWindow() {
		window = desktop.<Window>find("/Window[@caption='Calculator']");
		setButton1();
		setButton2();
		setButton3();
		setButton4();
		setButton5();
		setButton6();
		setButton7();
		setButton8();
		setButton9();
		setButton0();
		setButtonPlus();
		setButtonMinus();
		setButtonMultiply();
		setButtonDivide();
		setButtonResult();
		setButtonClear();
		setButtonClearEntry();
		setButtonDot();
		setLable();
		}


	public void close() {
		window.close();
	}


	public void assertResultIsZero() {
		resultField.assertResultIsZero();
	}


	public void assertResultEquals(Object expected) {
		resultField.assertResultEquals(expected);
	}

	public void setButton1(){
		button1 = new CalcPushButton(window, "1");
	}
	public void setButton2(){
		button2 = new CalcPushButton(window, "2");
	}
	public void setButton3(){
		button3 = new CalcPushButton(window, "3");
	}
	public void setButton4(){
		button4 = new CalcPushButton(window, "4");
	}
	public void setButton5(){
		button5 = new CalcPushButton(window, "5");
	}
	public void setButton6(){
		button6 = new CalcPushButton(window, "6");
	}
	public void setButton7(){
		button7 = new CalcPushButton(window, "7");
	}
	public void setButton8(){
		button8 = new CalcPushButton(window, "8");
	}
	public void setButton9(){
		button9 = new CalcPushButton(window, "9");
	}
	public void setButton0(){
		button0 = new CalcPushButton(window, "0");
	}
	public void setButtonPlus(){
		buttonPlus = new CalcPushButton(window, "+");
	}
	public void setButtonMinus(){
		buttonMinus = new CalcPushButton(window, "-");
	}
	public void setButtonMultiply(){
		buttonMultiply = new CalcPushButton(window, 21);
	}
	public void setButtonDivide(){
		buttonDivide = new CalcPushButton(window, "/");
	}
	public void setButtonResult(){
		buttonResult = new CalcPushButton(window, "=");
	}
	public void setButtonClear(){
		buttonClear = new CalcPushButton(window, "C");
	}
	public void setButtonClearEntry(){
		buttonClearEntry = new CalcPushButton(window, "CE");
	}
	public void setButtonDot(){
		buttonDot = new CalcPushButton(window, ".");
	}
	public void setLable(){
		resultField = new ResultField(window);
	}
}