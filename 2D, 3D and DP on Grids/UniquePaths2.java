class Solution {
    public int path(int i, int j, int[][] grid, int[][] dp){
        if(i >= 0 && j >= 0 && grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int up = path(i - 1, j, grid, dp);
        int left = path(i, j - 1, grid, dp);

        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return path(m-1, n-1, grid, dp);
    }
}

//Tabulation (Bottom - Up);

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) dp[i][j] = 0;
                if(i == 0 && j == 0) dp[i][j] = 1;

                else{
                    int up = 0, left = 0;
                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n-1][m-1];
    }
}
