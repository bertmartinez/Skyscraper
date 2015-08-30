import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

	private int a;
	private int b;
	private SkyscraperGame game;
	
	public GamePanel(int x, SkyscraperPlayer player) {
		a = x;
		b = x+2;
		this.setLayout(new GridLayout(b+1,b));
		game = new SkyscraperGame(a);
		
		int[] top = game.getTopView();
		int[] bottom = game.getBottomView();
		int[] left = game.getLeftView();
		int[] right = game.getRightView();
		int s = game.getSize();
		int[][] sol = game.getSolution();
		System.out.print("  ");
		for (int i=0; i<s; i++) {
			System.out.print(top[i]+" ");
		}
		System.out.println();
		System.out.println("*********************************");
		for (int r=0; r<s; r++) {
			System.out.print(left[r]+"* ");
			for (int c=0; c<s; c++) {
				System.out.print(sol[r][c]+" ");
			}
			System.out.println(" *"+right[r]);
		}
		System.out.println("**********************************");
		System.out.print("   ");
		for (int i=0; i<s; i++) {
			System.out.print(bottom[i]+" ");
		}
		
		SkyscraperButton[][] grid = game.getGrid();
		//int[] top = game.getTopView();
		//int[] bottom = game.getBottomView();
		//int[] left = game.getLeftView();
		//int[] right = game.getRightView();
		for (int r=0; r<b; r++) {
			for (int c=0; c<b; c++) {
				if (r==0 || r==b-1 || c==0 || c==b-1) {
					if ((r==0 || r==b-1) && (c==0 || c==b-1)) {
						JButton jb = new JButton("");
						this.add(jb);
						jb.setVisible(false);
					}
					else if (r==0) {
						JButton jb = new JButton(""+top[c-1]);
						this.add(jb);
					}
					else if (r==b-1) {
						JButton jb = new JButton(""+bottom[c-1]);
						this.add(jb);
					}
					else if (c==0) {
						JButton jb = new JButton(""+left[r-1]);
						this.add(jb);
					}
					else if (c==b-1) {
						JButton jb = new JButton(""+right[r-1]);
						this.add(jb);
					}
				}
				else {
					SkyscraperButton sb = grid[r-1][c-1];
					this.add(sb);
				}
			}
		}
		JButton newGame = new JButton("New Game");
		JButton check = new JButton("Check Answer");
		JButton solve = new JButton("Solve");
		JButton back = new JButton("Back");
		check.addActionListener(new CheckListener(game));
		solve.addActionListener(new SolveListener(game));
		back.addActionListener(new BackListener(player));
		add(newGame);
		add(check);
		add(solve);
		add(back);
	}
	
	public void solve() {
		game.solve();
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
}
