import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel{

	public WelcomePanel(SkyscraperPlayer player) {
		
		JLabel wel = new JLabel("Welcome: "); 
		JButton play = new JButton("Play");
		JButton rules = new JButton("Rules");
		JButton scores = new JButton("High Score");
		JButton[] choose = {play, rules, scores};
		play.addActionListener(new PlayListener(player));
		rules.addActionListener(new RulesListener());
		//wel.setBounds(200,200,100,100);
		//play.setBounds(100,100, 100,100);
		//wel.setLayout(null);
		//play.setLayout(null);
		add(wel); 
		add(play);
		add(rules);
		add(scores);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.PINK);
		g.setFont(new Font("TimesRoman", Font.BOLD, 25));
		g.drawString("Welcome to the Game", 125, 50);
	}
	
}
