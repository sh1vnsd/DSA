class Solution {
    public int f(int ind, int N, int[] price, int[][] dp){
        if(ind == 0){
            return N * price[ind];
        }
        if(dp[ind][N] != -1) return dp[ind][N];

        int notTake = f(ind - 1, N, price, dp);
        int take = Integer.MIN_VALUE;
            //rod length  
        if(ind + 1 <= N) take = price[ind] + f(ind, N - (ind + 1), price, dp);
        
        return dp[ind][N] = Math.max(take, notTake);
    }
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n - 1, n, price, dp);
    }
}


//Tabulation
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        for(int N = 0; N <= n; N++){
            dp[0][N] = N * price[0];
        }
        
        for(int ind = 1; ind < n; ind++){
            for(int N = 0; N <= n; N++){
                int notTake = dp[ind - 1][N];
                int take = 0;
                if(ind + 1 <= N) take = price[ind] + dp[ind][N - (ind + 1)];
                dp[ind][N] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][n];
    }
}


//Space Optimization
class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        for(int N = 0; N <= n; N++){
            prev[N] = N * price[0];
        }
        
        for(int ind = 1; ind < n; ind++){
            for(int N = 0; N <= n; N++){
                int notTake = prev[N];
                int take = 0;
                if(ind + 1 <= N) take = price[ind] + curr[N - (ind + 1)];
                curr[N] = Math.max(take, notTake);
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}
