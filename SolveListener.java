import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolveListener implements ActionListener {
	
	private SkyscraperGame game;
	
	public SolveListener(SkyscraperGame g) {
		game = g;
	}
	
	public void actionPerformed(ActionEvent e) {
		game.solve();
	}

}
