import java.util.ArrayDeque;
import java.util.Queue;

class Pair {
    int first, second, third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public int[][] nearest(int[][] grid) {
    	int n = grid.length;
    	int m = grid[0].length;
    	int[][] vis = new int[n][m];
    	int[][] dist = new int[n][m];
    	Queue<Pair> q = new ArrayDeque<Pair>();

    	for(int i=0; i<n; i++){
    		for(int j=0; j<m; j++){
    			if(grid[i][j] == 0){
    				vis[i][j] = 1;
    				q.add(new Pair(i, j, 0));
    			}
    			else{
    				vis[i][j] = 0;
    			}
    		}
    	}

    	while(!q.isEmpty()){
    		int row = q.peek().first;
    		int col = q.peek().second;
    		int steps = q.peek().third;
    		q.remove();

    		dist[row][col] = steps;
    		for(int i=0; i<4; i++){
    			int nRow = row + dRow[i];
    			int nCol = col + dCol[i];

    			if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
    				&& vis[nRow][nCol] == 0){
    				vis[nRow][nCol] = 1;
    				q.add(new Pair(nRow, nCol, steps+1));
    			}
    		}
    	}
    	return dist;
    }
}

public class zeroOneMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = solution.nearest(mat);

        System.out.println("Resultant Distance Matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
