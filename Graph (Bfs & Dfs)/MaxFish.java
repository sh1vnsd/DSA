import java.util.*;

class Pair {
    int first, second, third;
    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class MaxFish {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public int bfs(int ro, int co, int[][] vis, int[][] grid, int n, int m) {
        Queue<Pair> q = new ArrayDeque<>();
        vis[ro][co] = 1;
        q.add(new Pair(ro, co, grid[ro][co]));
        int totalFish = 0;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            totalFish += grid[row][col];
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && grid[nRow][nCol] > 0 && vis[nRow][nCol] == 0) {
                    q.add(new Pair(nRow, nCol, grid[nRow][nCol]));
                    vis[nRow][nCol] = 1;
                }
            }
        }
        return totalFish;
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int maxFish = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && vis[i][j] == 0) {
                    maxFish = Math.max(maxFish, bfs(i, j, vis, grid, n, m));
                }
            }
        }
        return maxFish;
    }



    public static void main(String[] args) {
        MaxFish solution = new MaxFish();

        // Example grid
        int[][] grid = {
            {0, 2, 0, 0},
            {4, 5, 7, 0},
            {0, 6, 0, 0},
            {0, 0, 0, 8}
        };

        // Calling the method and printing the result
        int maxFish = solution.findMaxFish(grid);
        System.out.println("Maximum fish that can be collected: " + maxFish);
    }

}
