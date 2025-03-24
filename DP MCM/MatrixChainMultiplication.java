class Solution {
    static int f(int i, int j, int[] arr, int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int mini = (int)(1e9);
        for(int k = i; k < j; k++){
            int steps = arr[i - 1] * arr[k] * arr[j] + f(i, k, arr, dp) + f(k + 1, j, arr, dp); 
            mini = Math.min(steps, mini);
        }
        return dp[i][j] = mini;
    }
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(1, n - 1, arr, dp);
    }
}

//Tabulation
class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for(int i = 1; i < n; i++) dp[i][i] = 0;
        
        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j < n; j++){
                int mini = (int)(1e9);
                for(int k = i; k < j; k++){
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    mini = Math.min(steps, mini);
                }
            dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
}


