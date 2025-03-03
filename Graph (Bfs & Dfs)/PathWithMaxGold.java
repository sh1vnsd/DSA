class PathWithMaxGold {
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxGold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(i, j, grid));
                }
            }
        }
        return maxGold;
    }

    public int dfs(int sR, int sC, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (sR < 0 || sR >= n || sC < 0 || sC >= m || grid[sR][sC] == 0) {
            return 0;
        }

        int gold = grid[sR][sC];
        grid[sR][sC] = 0; // Mark as visited
        int maxGold = 0;

        for (int i = 0; i < 4; i++) {
            int nRow = sR + dRow[i];
            int nCol = sC + dCol[i];
            maxGold = Math.max(maxGold, dfs(nRow, nCol, grid));
        }

        grid[sR][sC] = gold; // Backtrack
        return gold + maxGold;
    }
        public static void main(String[] args) {
        PathWithMaxGold solution = new PathWithMaxGold();

        int[][] grid = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };

        int result = solution.getMaximumGold(grid);
        System.out.println("Maximum Gold: " + result);
    }
}



