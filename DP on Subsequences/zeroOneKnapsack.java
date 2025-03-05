class Solution {
    static int f(int ind, int W, int[] val, int[] wt, int[][] dp){
        if(ind == 0){
            if(wt[0] <= W) return val[0];
            else return 0;
        }
        if(dp[ind][W] != -1) return dp[ind][W];

        int notPick = 0 + f(ind - 1, W, val, wt, dp);
        int pick = Integer.MIN_VALUE;
        if(wt[ind] <= W) pick = val[ind] + f(ind - 1, W - wt[ind], val, wt, dp);

        return dp[ind][W] = Math.max(pick, notPick);
    }
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];
        for(var row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, capacity, val, wt, dp);
    }
}


//Tabulation
class Solution {
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];
        
        for(int i = wt[0]; i <= capacity; i++) dp[0][i] = val[0];
        
        for(int ind = 1; ind < n; ind++){
            for(int W = 0; W <= capacity; W++){
                
                int notPick = dp[ind - 1][W];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= W) pick = val[ind] + dp[ind - 1][W - wt[ind]];
                
                dp[ind][W] = Math.max(notPick, pick);
        }
    }
    return dp[n - 1][capacity];
}
}

//Space Optimization
class Solution {
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[] prev = new int[capacity + 1];
        int[] curr = new int[capacity + 1];
        
        for(int i = wt[0]; i <= capacity; i++) prev[i] = val[0];
        
        for(int ind = 1; ind < n; ind++){
            for(int W = 0; W <= capacity; W++){
                
                int notPick = prev[W];
                int pick = Integer.MIN_VALUE;
                if(wt[ind] <= W) pick = val[ind] + prev[W - wt[ind]];
                
                curr[W] = Math.max(notPick, pick);
        }
        prev = curr.clone();
    }
    return prev[capacity];
}
}

