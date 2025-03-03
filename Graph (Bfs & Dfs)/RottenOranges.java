import java.util.*;
class Pair {
	int row, col, tm;
	Pair(int row, int col, int tm) {
		this.row = row;
		this.col = col;
		this.tm = tm;
	}
}

class RottenOranges {
	static int[] dRow = {-1, 0, 1, 0};
	static int[] dCol = {0, 1, 0, -1};

	public int orangesRotting(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] vis = new int[n][m];
		int cntFresh = 0;
		Queue<Pair> q = new ArrayDeque<Pair>();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j] == 2){
					vis[i][j] = 2;
					q.add(new Pair(i, j, 0));
				}
				else{
					vis[i][j] = 0;
				}

				if(grid[i][j] == 1) cntFresh++;
			}
		}

		int time = 0;
		int cnt = 0;
		while(!q.isEmpty()){
			int row = q.peek().row;
			int col = q.peek().col;
			int t = q.peek().tm;
			q.remove();

			time = Math.max(time, t);
			for(int i=0; i<4; i++){
				int nRow = row + dRow[i];
				int nCol = col + dCol[i];

				if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
					&& vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
					cnt++;
					vis[nRow][nCol] = 2;
					q.add(new Pair(nRow, nCol, t+1));
				}
			}
		}
		if(cnt!=cntFresh) return -1;
		return time;
	}


	public static void main(String[] args) {
		int[][] grid = {
			{2, 1, 1},
			{1, 1, 0},
			{0, 1, 1}
		};

		RottenOranges solution = new RottenOranges();
		int result = solution.orangesRotting(grid);
		System.out.println("Minimum time required to rot all oranges: " + result);
	}

}
