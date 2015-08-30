import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayListener implements ActionListener {
	
	private SkyscraperPlayer sky;
	
	public PlayListener(SkyscraperPlayer player) {
		sky = player;
	}
	
	public void actionPerformed(ActionEvent e) {
		sky.play();
	}

}
