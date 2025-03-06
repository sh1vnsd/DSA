class Solution {
    static int f(int ind, int W, int[][] dp, int[] val, int[] wt){
        if(ind == 0){
            return (W / wt[ind]) * val[ind];
        }
        if(dp[ind][W] != -1) return dp[ind][W];

        int notPick = 0 + f(ind - 1, W, dp, val, wt);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= W) pick = val[ind] + f(ind, W - wt[ind], dp, val, wt);

        return dp[ind][W] = Math.max(pick, notPick);
    }
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        return f(n - 1, capacity, dp, val, wt);
    }
}



//Tablutaion 
class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];
        for(int i = 0; i <= capacity; i++) {
            dp[0][i] = (i / wt[0]) * val[0];
        }
        
        for(int ind = 1; ind < n; ind++){
            for(int W = 0; W <= capacity; W++){
                int notPick = dp[ind - 1][W];
                int pick = 0;
                if(wt[ind] <= W) pick = val[ind] + dp[ind][W - wt[ind]];
                dp[ind][W] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][capacity];
    }
}


//Space Optimized
class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[] prev = new int[capacity + 1];
        int[] curr = new int[capacity + 1];
        for(int i = 0; i <= capacity; i++) {
            prev[i] = (i / wt[0]) * val[0];
        }
        
        for(int ind = 1; ind < n; ind++){
            for(int W = 0; W <= capacity; W++){
                int notPick = prev[W];
                int pick = 0;
                if(wt[ind] <= W) pick = val[ind] + curr[W - wt[ind]];
                curr[W] = Math.max(pick, notPick);
            }
            prev = curr.clone();
        }
        return prev[capacity];
    }
}



//1-D Array Space Optimized
class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[] prev = new int[capacity + 1];
        for(int i = 0; i <= capacity; i++) {
            prev[i] = (i / wt[0]) * val[0];
        }
        
        for(int ind = 1; ind < n; ind++){
            for(int W = 0; W <= capacity; W++){
                int notPick = prev[W];
                int pick = 0;
                if(wt[ind] <= W) pick = val[ind] + prev[W - wt[ind]];
                prev[W] = Math.max(pick, notPick);
            }
        }
        return prev[capacity];
    }
}
