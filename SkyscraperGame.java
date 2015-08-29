
public class SkyscraperGame {
	
	private int size;
	private SkyscraperButton[][] grid;
	private int[][] solution;
	private int[] topView;
	private int[] bottomView;
	private int[] leftView;
	private int[] rightView;
	
	public SkyscraperGame(int s) {
		size = s;
		generateSolution();
		setSights();
		grid = new SkyscraperButton[size][size];
		for (int r=0; r<s; r++) {
			for (int c=0; c<s; c++) {
				grid[r][c] = new SkyscraperButton(s);
			}
		}
	}

	public void generateSolution() {
		solution = new int[size][size];
		for (int r=0; r<size; r++) {
			for (int c=0; c<size; c++) {
				int set = 1+c+r;
				if (set<=size)
					solution[r][c] = set;
				else 
					solution[r][c] = set-size;
			}
		}
		randomizeIt();
	}
	
	public void setSights(){
		topView = new int[size];
		bottomView = new int[size];
		leftView = new int[size];
		rightView = new int[size];
		for (int c=0; c<size; c++) {
			topView[c] = 0;
			int tallest = 0;
			for (int r=0; r<size; r++) {
				if (solution[r][c]>tallest) {
					topView[c]++;
					tallest = solution[r][c];
				}
			}
		}
		for (int c=size-1; c>=0; c--) {
			bottomView[c] = 0;
			int tallest = 0;
			for (int r=size-1; r>=0; r--) {
				if (solution[r][c]>tallest) {
					bottomView[c]++;
					tallest = solution[r][c];
				}
			}
		}
		for (int r=0; r<size; r++) {
			leftView[r] = 0;
			int tallest = 0; 
			for (int c=0; c<size; c++) {
				if (solution[r][c]>tallest) {
					leftView[r]++;
					tallest = solution[r][c];
				}
			}
		}
		for (int r=size-1; r>=0; r--) {
			rightView[r] = 0;
			int tallest = 0;
			for (int c=size-1; c>=0; c--) {
				if (solution[r][c]>tallest) {
					rightView[r]++;
					tallest = solution[r][c];
				}
			}
		}
	}
	
	public void randomizeIt() {
		int[] temp = new int[size];
		for (int r=0; r<size; r++) {
			int a = (int)(Math.random()*size);
			for (int c=0; c<size; c++) {
				temp[c] = solution[r][c];
				solution[r][c] = solution[a][c];
				solution[a][c] = temp[c];
			}
		}
		for (int c=0; c<size; c++) {
			int a = (int)(Math.random()*size);
			for (int r=0; r<size; r++) {
				temp[r] = solution[r][c];
				solution[r][c] = solution[r][a];
				solution[r][a] = temp[r];
			}
		}
	}
		
	public int getSize() {
		return size;
	}
	public int[][] getSolution() {
		return solution;
	}
	public int[] getTopView() {
		return topView;
	}
	public int[] getBottomView() {
		return bottomView;
	}
	public int[] getLeftView() {
		return leftView;
	}
	public int[] getRightView() {
		return rightView;
	}
	public SkyscraperButton[][] getGrid() {
		return grid;
	}
	
	public void solve() {
		for (int c=0; c<size; c++) {
			for (int r=0; r<size; r++) {
				grid[r][c].setValue(solution[r][c]);
			}
		}
	}
		
	public boolean check() {
		for (int r=0; r<size; r++) {
			int seen = leftView[r];
			int tallest = 0;
			for (int c=0; c<size; c++) {
				for (int C=0; C<size; C++) {
					if ((c!=C) && (grid[r][c].getValue()==grid[r][C].getValue())) {
						System.out.println("A");
						return false;
					}
				}
				if (grid[r][c].getValue()>tallest) {
					tallest = grid[r][c].getValue();
					seen--;
					
				}
			}
			if (seen!=0) {
				System.out.println("B   r="+r+"  seen="+seen);
				return false;
			}
		}
		for (int r=size-1; r>=0; r--) {
			int seen = rightView[r];
			int tallest = 0;
			for (int c=size-1; c>=0; c--) {
				if (grid[r][c].getValue()>tallest) {
					tallest = grid[r][c].getValue();
					seen--;
				}
			}
			if (seen!=0) {
				System.out.println("C");
				return false;
			}
		}
		for (int c=0; c<size; c++) {
			int seen = topView[c];
			int tallest = 0;
			for (int r=0; r<size; r++) {
				for (int R=0; R<size; R++) {
					if ((r!=R) && (grid[r][c].getValue()==grid[R][c].getValue())) {
						System.out.println("D");
						return false;
					}
				}
				if (grid[r][c].getValue()>tallest) {
					tallest = grid[r][c].getValue();
					seen--;
				}
			}
			if (seen!=0) {
				System.out.println("E");
				return false;
			}
		}
		for (int c=size-1; c>=0; c--) {
			int seen = bottomView[c];
			int tallest = 0;
			for (int r=size-1; r>=0; r--) {
				if (grid[r][c].getValue()>tallest) {
					tallest = grid[r][c].getValue();
					seen--;
				}
			}
			if (seen!=0) {
				System.out.println("F");
				return false;
			}
		}
		return true;
	}

/*
	public static void main(String []args) {
		SkyscraperGame game = new SkyscraperGame(15);
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
	}
*/
	
}
