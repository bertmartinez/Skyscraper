import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.*;


public class SkyscraperPlayer {
	
	private static JFrame jf = new JFrame();
	
	public SkyscraperPlayer() {
		init();
	}
	
	public void init() {
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("Skyscrapper the Game");
		jf.setSize(700,700);
		jf.setVisible(true);
		welcome();
	}
	
	public void welcome() {
		//jf.removeAll();
		WelcomePanel welcome = new WelcomePanel(this);
		jf.add(welcome);
		welcome.setVisible(true);
		jf.repaint();
		
	}
	
	public void play() {
		//jf.removeAll();
		//jf.revalidate();
		//jf.repaint();
		GamePanel game = new GamePanel(5, this);
		jf.add(game);
		game.setVisible(true);
		jf.repaint();
	} 
	
}
