class Solution {
    public int f(int ind, int target, int[] coins, int[][] dp) {
        if (ind == 0) {
            return (target % coins[ind] == 0) ? 1 : 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notPick = 0 + f(ind - 1, target, coins, dp);
        int pick = 0;
        if (coins[ind] <= target)
            pick = f(ind, target - coins[ind], coins, dp);

        return dp[ind][target] = notPick + pick;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (var row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, amount, coins, dp);
    }
}


//Tabultaion 
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int target = 0; target <= amount; target++) dp[0][target] = (target % coins[0] == 0) ? 1 : 0;
        for(int ind = 1; ind < n; ind++){
            for(int tar = 0; tar <= amount; tar++){
                int notPick = dp[ind - 1][tar];
                int pick = 0;
                if(coins[ind] <= tar) pick = dp[ind][tar - coins[ind]];
                dp[ind][tar] = pick + notPick;
            }
        }
        return dp[n - 1][amount];
    }
}


//Space Optimization
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        int[] curr = new int[amount + 1];
        for(int target = 0; target <= amount; target++) prev[target] = (target % coins[0] == 0) ? 1 : 0;
        for(int ind = 1; ind < n; ind++){
            for(int tar = 0; tar <= amount; tar++){
                int notPick = prev[tar];
                int pick = 0;
                if(coins[ind] <= tar) pick = curr[tar - coins[ind]];
                curr[tar] = pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}

