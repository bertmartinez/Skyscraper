import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkyscraperButtonListener implements ActionListener {
	
	private SkyscraperButton butt;
	private int limit;
	
	public SkyscraperButtonListener(SkyscraperButton sky) {
		butt = sky;
		limit = butt.getLimit();
	}

	public void actionPerformed(ActionEvent e) {
		if (butt.getValue()<limit) {
			butt.setValue(butt.getValue()+1);
		}
		else {
			butt.setValue(0);
		}
	}
	
}
