class Solution {
    public int f(int i, int j, int[][] dp, int[][] grid){
        if(i >= 0 && j >= 0 && grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int up = f(i - 1, j, dp, grid);
        int left = f(i, j - 1, dp, grid);

        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(var row : dp){
            Arrays.fill(row, -1);
        }

        return f(n - 1, m - 1, dp, grid);
    }
}
