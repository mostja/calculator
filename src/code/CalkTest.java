package code;
import java.io.IOException;


import com.borland.silktest.jtf.Desktop;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.borland.silktest.jtf.BaseState;

import com.borland.silktest.jtf.PushButton;
import com.borland.silktest.jtf.Label;
import com.borland.silktest.jtf.Window;
import com.borland.silktest.jtf.common.types.Point;
import com.borland.silktest.jtf.common.types.ModifierKey;


public class CalkTest {

	private Desktop desktop = new Desktop();
	CalculatorWindow firstCalc;
	
	@BeforeMethod
	public void baseState() {
		BaseState baseState = new BaseState("code\\silk4j.settings");
		try {
			Runtime.getRuntime().exec("C:\\Windows\\system32\\calc.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		baseState.execute(desktop);
		firstCalc = new CalculatorWindow();
	}
	
	@AfterMethod
	public void tearDown(){
		firstCalc.close();
	}
	
	@Test
	public void testBaseState() {
		firstCalc.resultField.assertResultIsZero();
	}
	@Test
	public void testBaseInput() {
		firstCalc.button1.select();
		firstCalc.button2.select();
		firstCalc.button3.select();
		firstCalc.button4.select();
		firstCalc.button5.select();
		firstCalc.button6.select();
		firstCalc.button7.select();
		firstCalc.button8.select();
		firstCalc.button9.select();
		firstCalc.button0.select();
		firstCalc.buttonDot.select();
		firstCalc.button1.select();
		Assert.assertEquals(firstCalc.resultField.getValue(), "1234567890.1");
	}
	
	@Test
	public void testCalcPlus() {
		
		firstCalc.button5.select();
		firstCalc.buttonPlus.click();
		firstCalc.button8.select();
		firstCalc.buttonPlus.select();
		firstCalc.button7.select();
		firstCalc.buttonResult.select();
		System.out.println(firstCalc.resultField.getValue()); 
		Assert.assertEquals(firstCalc.resultField.getValue(), "20");
	}
	@Test
	public void testCalcMultipy() {
		
		firstCalc.button5.select();
		firstCalc.buttonMultiply.select();
		firstCalc.button8.select();
		firstCalc.buttonResult.select();
		System.out.println(firstCalc.resultField.getValue()); 
		Assert.assertEquals(firstCalc.resultField.getValue(), "40");
	}
	@Test
	public void testCalcMinus() {
		
		firstCalc.button5.select();
		firstCalc.button2.select();
		firstCalc.buttonMinus.select();
		firstCalc.button8.select();
		firstCalc.buttonResult.select();
		System.out.println(firstCalc.resultField.getValue()); 
		Assert.assertEquals(firstCalc.resultField.getValue(), "44");
	}
	@Test
	public void testCalcDivide() {
		
		firstCalc.button2.select();
		firstCalc.button5.select();
		firstCalc.buttonDivide.select();
		firstCalc.button5.select();
		firstCalc.buttonResult.select();
		System.out.println(firstCalc.resultField.getValue()); 
		Assert.assertEquals(firstCalc.resultField.getValue(), "5");
	}

	@Test 
	public void testDivExcept(){
		firstCalc.button8.select();
		firstCalc.buttonDivide.select();
		firstCalc.button0.select();
		firstCalc.buttonResult.select();
		firstCalc.resultField.assertDivExcept();
		System.out.println(firstCalc.resultField.getValue()); 
	}
	@Test
	public void testCalcLarge(){
		for (int i = 0; i < 16; i++){
			firstCalc.button9.select();
		}
		firstCalc.buttonMultiply.select();
		for (int i = 0; i < 16; i++){
			firstCalc.button8.select();
		}
		firstCalc.buttonResult.select();
		Assert.assertEquals(firstCalc.resultField.getValue(), "8.888888888888887e+31");
	}
	
	@Test
	public void testMaxNumberDigitsInput(){
		for (int i = 0; i < 18; i++){
			firstCalc.button5.select();
		}
		firstCalc.resultField.assertMaxNumberOfDigits();
	}
	
	@Test
	public void testInputFirstZero(){
		firstCalc.button0.select();
		firstCalc.button2.select();
		firstCalc.button5.select();
		Assert.assertEquals(firstCalc.resultField.getValue(), "25");
	}
	
	@Test
	public void testInputSeveralDots(){
		firstCalc.button2.select();
		firstCalc.buttonDot.select();
		firstCalc.buttonDot.select();
		firstCalc.buttonDot.select();
		Assert.assertEquals(firstCalc.resultField.getValue(), "2.");
	}
	@Test
	public void testVolume(){
		for (int i = 0; i < 1000; i++){
			firstCalc.button1.select();
			firstCalc.buttonPlus.select();
		}
		Assert.assertEquals(firstCalc.resultField.getValue(), "1000");
		System.out.println(firstCalc.resultField.getValue());
	}
	@Test
	public void testClearButton(){
		for (int i = 0; i < 7; i++){
			firstCalc.button4.select();
		}
		firstCalc.buttonClear.select();
		firstCalc.resultField.assertResultIsZero();
	
	}
	@Test
	public void testClearEntryButton(){
		firstCalc.button8.select();
		firstCalc.button1.select();
		firstCalc.buttonPlus.select();
		firstCalc.button5.select();
		firstCalc.button6.select();
		firstCalc.buttonClearEntry.select();
		firstCalc.resultField.assertResultIsZero();
		firstCalc.button9.select();
		firstCalc.buttonResult.select();
		Assert.assertEquals(firstCalc.resultField.getValue(), "90");
	}
	@Test
	public void testNegativeNumbers(){
		firstCalc.button5.select();
		firstCalc.button0.select();
		firstCalc.buttonMinus.select();
		firstCalc.button5.select();
		firstCalc.button6.select();
		firstCalc.buttonResult.select();
		Assert.assertEquals(firstCalc.resultField.getValue(), "-6");
	}

}