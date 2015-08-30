import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackListener implements ActionListener {
	
	private SkyscraperPlayer sky;
	
	public BackListener(SkyscraperPlayer player) {
		sky = player;
	}
	
	public void actionPerformed(ActionEvent e) {
		sky.welcome();
	}

}
