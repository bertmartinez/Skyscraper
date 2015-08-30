import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckListener implements ActionListener {
	
	private SkyscraperGame game;
	
	public CheckListener(SkyscraperGame g) {
		game = g;
	}

	public void actionPerformed(ActionEvent e) {
		boolean done = game.check();
		if (done)
			System.out.println("Winner!!");
		else if (!done)
			System.out.println("Loser!!");
	}
	
}
