import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SkyscraperButton extends JButton {
	
	private int value;
	private int limit;
	
	public SkyscraperButton(int l) {
		value = 0;
		limit = l;
		this.setText(""+value);
		addActionListener(new SkyscraperButtonListener(this));
		//System.out.println("JButton");
	}
	
	public int getLimit() {
		return limit;
	}
	public void setValue(int i) {
		value = i;
		setText(""+value);
	}
	public int getValue() {
		return value;
	}

}
