class Solution {
    public int min(int i, int j, int[][] matrix, int[][] dp, int n){
        if(j < 0 || j >= n) return (int)(1e9);
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];

        int up = matrix[i][j] + min(i - 1, j, matrix, dp, n);
        int upLeft = matrix[i][j] + min(i - 1, j - 1, matrix, dp, n);
        int upRight = matrix[i][j] + min(i - 1, j + 1, matrix, dp, n);

        return dp[i][j] = Math.min(up, Math.min(upLeft, upRight));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(var row : dp){
            Arrays.fill(row, -1);
        } 
        int minSum = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            minSum = Math.min(minSum, min(n-1, j, matrix, dp, n));
        }
        return minSum;
    }
}

//Tabulation
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++) dp[0][j] = matrix[0][j];

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int up = matrix[i][j] + dp[i - 1][j];
                int upLeft = matrix[i][j];
                if(j - 1 >= 0){
                    upLeft += dp[i - 1][j - 1];
                }
                else{
                    upLeft += (int)(1e9);
                }
                int upRight = matrix[i][j];
                if(j + 1 < n){
                    upRight += dp[i - 1][j + 1];
                }
                else{
                    upRight += (int)(1e9);
                }

                dp[i][j] = Math.min(up, Math.min(upLeft, upRight));
            }
        }



        int minSum = (int)(1e9);
        for(int j = 0; j < n; j++){
            minSum = Math.min(minSum, dp[n-1][j]);
        }
        return minSum;
    }
}

//Space Optimization
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];
        int[] curr = new int[n];

        // Initialize prev with the first row of the matrix
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + prev[j];

                int upLeft = matrix[i][j];
                if (j - 1 >= 0) {
                    upLeft += prev[j - 1];
                } else {
                    upLeft += (int)(1e9);
                }

                int upRight = matrix[i][j];
                if (j + 1 < n) {
                    upRight += prev[j + 1];
                } else {
                    upRight += (int)(1e9);
                }

                curr[j] = Math.min(up, Math.min(upLeft, upRight));
            }
            prev = curr; // Directly assign curr to prev
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, prev[j]);
        }
        return minSum;
    }
}

