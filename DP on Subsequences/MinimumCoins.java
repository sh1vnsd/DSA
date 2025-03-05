class Solution {
    public int f(int ind, int target, int[][] dp, int[] coins){
        if(ind == 0){
            if(target % coins[ind] == 0) return target / coins[ind];
            else return (int)(1e9);
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int notPick = f(ind - 1, target, dp, coins);
        int pick = Integer.MAX_VALUE; 
        if(coins[ind] <= target) pick = 1 + f(ind, target - coins[ind], dp, coins);
        return dp[ind][target] = Math.min(notPick, pick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(var row : dp){
            Arrays.fill(row, -1);
        }
        int ans =  f(n - 1, amount, dp, coins);
        return(ans >= (int)(1e9)) ? -1 : ans;
    }
}


//Tabultaion
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] =  (int)(1e9);
        }

        for(int ind = 1; ind < n; ind++){
            for(int target = 0; target <= amount; target++){
                int notPick = dp[ind - 1][target];
                int pick = Integer.MAX_VALUE;
                if(coins[ind] <= target) pick = 1 + dp[ind][target - coins[ind]];
                dp[ind][target] = Math.min(notPick, pick);
            }
        }
        int ans = dp[n - 1][amount];
        return (ans >= (int)(1e9)) ? -1 : ans;
    }
}


//Space Optimization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for(int i = 0; i <= amount; i++){
            if(i % coins[0] == 0) prev[i] = i / coins[0];
            else prev[i] =  (int)(1e9);
        }

        for(int ind = 1; ind < n; ind++){
            for(int target = 0; target <= amount; target++){
                int notPick = prev[target];
                int pick = Integer.MAX_VALUE;
                if(coins[ind] <= target) pick = 1 + curr[target - coins[ind]];
                curr[target] = Math.min(notPick, pick);
            }
            prev = curr;
        }
        int ans = prev[amount];
        return (ans >= (int)(1e9)) ? -1 : ans;
    }
}

