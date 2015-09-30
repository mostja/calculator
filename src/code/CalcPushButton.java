package code;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.PushButton;
import com.borland.silktest.jtf.Window;
import com.borland.silktest.jtf.common.types.ModifierKey;
import com.borland.silktest.jtf.common.types.Point;
import com.borland.silktest.jtf.common.types.Rect;

public class CalcPushButton {

	private Desktop desktop = new Desktop();
	public PushButton button;
	public String caption;
		
	public CalcPushButton(Window Parent, String caption){
		setButton(Parent, caption);
	}
	public CalcPushButton(Window Parent, Integer id){
		setButtonMultipy(Parent, id);
	}
	
	public void setButton(Window Parent, String caption1){
		button = Parent.<PushButton>find("//PushButton[@caption='"+caption1+"']");
	}
	
	public void setButtonMultipy(Window Parent, Integer id){
		button = Parent.<PushButton>find("//PushButton["+id.toString()+"]");
	}
	
	public Object getValue() {
		return button.getValue();
	}

	public String captureBitmap(String fileName, Rect region) {
		return button.captureBitmap(fileName, region);
	}

	public String captureBitmap(String fileName) {

		return button.captureBitmap(fileName);
	}
	
	public void click(){
		select();
	}

 	public void doubleClick() {
		button.doubleClick();
	}

	public void doubleClick(int button, Point pos, ModifierKey modifiers) {
		this.button.doubleClick(button, pos, modifiers);
	}

	public void doubleClick(int button, Point pos) {
		this.button.doubleClick(button, pos);
	}

	public void doubleClick(int button) {
		this.button.doubleClick(button);
	}

	public boolean equals(Object obj) {
		return button.equals(obj);
	}

	public void select() {
		button.select();
	}

	public String toString() {
		return button.toString();
	}
}