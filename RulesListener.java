import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class RulesListener implements ActionListener{
	
	public RulesListener() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JFrame ruleFrame = new JFrame();
		ruleFrame.setSize(350, 220);
		ruleFrame.setVisible(true);
		JTextArea rules = new JTextArea("Welcome to Skyscraper the game! \n"
				+ "The buttons in the grid each represent a building. \n"
				+ "The numbers in the buildings represent their height \n"
				+ "(ranging from 0 to 5). Each row and column can only \n"
				+ "have one building of each hieght. The numbers outside \n"
				+ "of the building grid represent how many buildings can \n"
				+ "be seen from that point of view. Abuilding can be \n"
				+ "seen as long as there is no building taller than \n"
				+ "itself between it and the point of view. Good Luck!");
		ruleFrame.add(rules);
		
	}

}
